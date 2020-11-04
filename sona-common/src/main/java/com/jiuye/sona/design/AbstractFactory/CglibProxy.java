package com.jiuye.sona.design.AbstractFactory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: xinjian.hu
 * @Date: 2020/11/4 17:39
 * @Email: huxinjian@jiuyescm.com
 */
public class CglibProxy implements MethodInterceptor {

    /**
     *
     * @param clazz
     * @return
     */
    public Object CreatProxyedObj(Class<?> clazz)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o, objects);
    }
}
