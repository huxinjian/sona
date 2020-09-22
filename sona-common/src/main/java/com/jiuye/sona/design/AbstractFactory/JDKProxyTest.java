package com.jiuye.sona.design.AbstractFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/22 15:47
 * @Email: huxinjian@jiuyescm.com
 */
@Slf4j
public class JDKProxyTest {


    public static void main(String[] args) {
        ICacheAdapter egmProxy = JDKProxy.getProxy(new EGMCacheAdapter());
        egmProxy.set("egmTest", "egm");
        String egmResult = egmProxy.get("egmTest");
        System.out.println("获取到的结果是:" + egmResult);
        ICacheAdapter iirProxy = JDKProxy.getProxy(new IIRCacheAdapter());
        String iirResult = iirProxy.get("egmTest");
        System.out.println("获取到的结果是:" + iirResult);
    }
}
