package com.jiuye.sona.design.AbstractFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/22 15:28
 * @Email: huxinjian@jiuyescm.com
 */
public class JDKProxy {

    /**
     * 获取类对象
     *
     * @param cacheAdapter
     * @param <T>
     * @return
     */
    public static <T> T getProxy(T cacheAdapter) {
        InvocationHandler handler = new JDKInvocationHandler(cacheAdapter);
        // 获取当前的类加载器
        ClassLoader classLoader = cacheAdapter.getClass().getClassLoader();
        // 获取接口
        Class<?>[] classes = cacheAdapter.getClass().getInterfaces();
        // 根据接口获取当前类
        return (T) Proxy.newProxyInstance(classLoader, classes,
            handler);
    }
}
