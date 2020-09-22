package com.jiuye.sona.design.AbstractFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/22 15:11
 * @Email: huxinjian@jiuyescm.com
 */
public interface ICacheAdapter {

    /**
     * 获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 新增数据
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 新增数据（带有过期时间）
     * @param key
     * @param value
     * @param timeout
     * @param timeUnit
     */
    void set(String key, String value, long timeout, TimeUnit timeUnit);

    /**
     * 删除数据
     *
     * @param key
     */
    void del(String key);
}
