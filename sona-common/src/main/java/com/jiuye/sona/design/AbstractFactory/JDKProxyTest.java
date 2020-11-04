package com.jiuye.sona.design.AbstractFactory;


/**
 * @Author: xinjian.hu
 * @Date: 2020/9/22 15:47
 * @Email: huxinjian@jiuyescm.com
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        ICacheAdapter egmProxy = JDKProxy.getProxy(new EGMCacheAdapter());
        egmProxy.set("egmTest", "egm");
        String egmResult = egmProxy.get("egmTest");
        System.out.println("获取到的结果是:" + egmResult);
        ICacheAdapter iirProxy = JDKProxy.getProxy(new IIRCacheAdapter());
        String iirResult = iirProxy.get("egmTest");
        System.out.println("获取到的结果是:" + iirResult);


        CglibProxy cglibProxy = new CglibProxy();
        ICacheAdapter egmProxy2 = (ICacheAdapter) cglibProxy.CreatProxyedObj(EGMCacheAdapter.class);
        egmProxy2.set("123","123");
        String result = egmProxy2.get("123");
        System.out.println("cglib 返回结果是： " + result);
    }
}
