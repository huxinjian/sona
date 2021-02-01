package com.jiuye.sona.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author: xinjian.hu
 * @Date: 2021/1/26 10:36
 * @Email: huxinjian@jiuyescm.com
 */
public class ServiceLoaderTest {

    public static void main(String[] args) {

        ServiceLoader<CacheStore> loader = ServiceLoader.load(CacheStore.class);
        Iterator<CacheStore> iterator = loader.iterator();
        while (iterator.hasNext()) {
            CacheStore cacheStore =  iterator.next();
            cacheStore.put("hh","hh");
        }
    }
}
