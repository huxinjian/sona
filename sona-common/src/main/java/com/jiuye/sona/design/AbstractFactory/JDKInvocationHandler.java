package com.jiuye.sona.design.AbstractFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/22 15:29
 * @Email: huxinjian@jiuyescm.com
 */
public class  JDKInvocationHandler<T> implements InvocationHandler {

    private T cacheAdapter;

    public JDKInvocationHandler(T cacheAdapter){
        this.cacheAdapter = cacheAdapter;
    }

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(cacheAdapter, args);
        return result;
    }
}
