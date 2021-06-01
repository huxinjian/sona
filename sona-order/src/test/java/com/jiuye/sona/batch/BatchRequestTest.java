package com.jiuye.sona.batch;

import com.jiuye.sona.service.impl.batch.CommodityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: xinjian.hu
 * @Date: 2021/5/31 16:45
 * @Email: huxinjian@jiuyescm.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchRequestTest {

    @Autowired
    private CommodityService commodityService;

    @Test
    public void benchmark() throws IOException {
        CountDownLatch countDownLatch = new CountDownLatch(1000);
        // 创建 并不是马上发起请求
        for (int i = 0; i < 1000; i++) {
            final String code = "code-" + (i + 1); // 番号
            // 多线程模拟用户查询请求
            Thread thread = new Thread(() -> {
                try {
                    // 代码在这里等待，等待countDownLatch为0，代表所有线程都start，再运行后续的代码
                    countDownLatch.await();
                    // http请求，实际上就是多线程调用这个方法
                    Map<String, Object> result = commodityService.queryCommodity(code);
                    System.out.println(Thread.currentThread().getName() + " 查询结束，结果是：" + result);
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + " 线程执行出现异常:" + e.getMessage());
                }
            });
            thread.setName("price-thread-" + code);
            thread.start();
            // 田径。启动后，倒计时器倒计数 减一，代表又有一个线程就绪了
            countDownLatch.countDown();
        }

        // 输入任意内容退出
        System.in.read();
    }
}
