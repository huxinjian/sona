package com.jiuye.sona.service.impl.batch;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: xinjian.hu
 * @Date: 2021/5/31 16:41
 * @Email: huxinjian@jiuyescm.com
 */
@Service
public class QueryServiceRemoteCall {

    public HashMap<String, Object> queryCommodityByCode(String code) {
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("commodityId", new Random().nextInt(999999999));
        hashMap.put("code", code);
        hashMap.put("phone", "huawei");
        hashMap.put("isOk", "true");
        hashMap.put("price","4000");
        return hashMap;
    }
    public List<Map<String, Object>> queryCommodityByCodeBatch(List<String> codes) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (String code : codes) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("commodityId", new Random().nextInt(999999999));
            hashMap.put("code", code);
            hashMap.put("phone", "huawei");
            hashMap.put("isOk", "true");
            hashMap.put("price","4000");
            result.add(hashMap);
        }
        return result;
    }
}
