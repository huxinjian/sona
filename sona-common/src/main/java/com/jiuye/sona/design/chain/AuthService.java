package com.jiuye.sona.design.chain;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/27 19:08
 * @Email: huxinjian@jiuyescm.com
 */
public class AuthService {


    private static Map<String, Date> authMap = new ConcurrentHashMap<>();

    /**
     *
     * @param uId
     * @param orderId
     * @return
     */
    public static Date queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }

    /**
     *
     * @param uId
     * @param orderId
     */
    public static void auth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), new Date());
    }
}
