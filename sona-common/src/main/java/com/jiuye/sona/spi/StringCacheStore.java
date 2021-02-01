package com.jiuye.sona.spi;

/**
 * @Author: xinjian.hu
 * @Date: 2021/1/26 10:21
 * @Email: huxinjian@jiuyescm.com
 */
public class StringCacheStore implements CacheStore<String, String> {

    /**
     * 
     * @param key
     * @param value
     */
    @Override
    public void put(String key, String value) {
        String s="put key:%s value:%s";
        System.out.println(String.format(s,key, value));
    }
}
