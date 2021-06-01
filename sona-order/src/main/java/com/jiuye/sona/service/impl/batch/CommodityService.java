package com.jiuye.sona.service.impl.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

/**
 * @Author: xinjian.hu
 * @Date: 2021/5/31 16:36
 * @Email: huxinjian@jiuyescm.com
 */
@Service("commodityService")
public class CommodityService {

    @Autowired
    private QueryServiceRemoteCall queryServiceRemoteCall;

    class Request{

        String commdityCode;

        CompletableFuture<Map<String, Object>> future;
    }

    LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    @PostConstruct
    public void init(){
        ScheduledExecutorService scheduledExecutorService = newScheduledThreadPool(3);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            // 1、 取出queue的请求，生成一次批量查询
            int size = queue.size();
            if (size == 0) {
                return;
            }
            ArrayList<Request> requests = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Request request = queue.poll();
                requests.add(request);
            }
            System.out.println("批量处理数据量:" + size);
            // 2、 组装一个批量查询（一定需要 目的资源能够支持批量查询。 http）
            ArrayList<String> commodityCodes = new ArrayList<>();
            for (Request request : requests) {
                commodityCodes.add(request.commdityCode);
            }
            List<Map<String, Object>> responses = queryServiceRemoteCall.queryCommodityByCodeBatch(commodityCodes);

            // 3、将结果响应 分发给每一个单独的用户请求。  由定时任务处理线程 --> 1000个用户的请求线程
            // [
            // {"code":"500",star: tony}
            // {"code":"600",star: tony}
            // ]
            HashMap<String, Map<String, Object>> responseMap = new HashMap<>();
            for (Map<String, Object> response : responses) {
                String code = response.get("code").toString();
                responseMap.put(code, response);
            }
            for (Request request : requests) {
                // 根据请求中携带的能表示唯一参数，去批量查询的结果中找响应
                Map<String, Object> result = responseMap.get(request.commdityCode);
                // 将结果返回到对应的请求线程
                request.future.complete(result);
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }



    public Map<String, Object> queryCommodity(String movieCode) throws ExecutionException, InterruptedException {
        // 1000次 怎么样才能变成  更少的接口
        // 思路： 将不同用户的同类请求合并起来
        // 并非立刻发起接口调用，请求 收集起来，再进行
        Request request = new Request();
        request.commdityCode = movieCode;
        // 异步编程： 获取异步处理的结果
        CompletableFuture<Map<String, Object>> future = new CompletableFuture<>();
        request.future = future;
        queue.add(request);
        return future.get();
    }
}
