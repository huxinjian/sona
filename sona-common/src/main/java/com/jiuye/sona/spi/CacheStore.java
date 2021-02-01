package com.jiuye.sona.spi;

/**
 * @Author: xinjian.hu
 * @Date: 2021/1/26 10:20
 * @Email: huxinjian@jiuyescm.com
 */
public interface CacheStore<K, V> {

    void put(K key, V value);
}
