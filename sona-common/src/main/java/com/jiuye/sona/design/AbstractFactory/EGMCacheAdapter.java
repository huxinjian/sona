package com.jiuye.sona.design.AbstractFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/22 15:13
 * @Email: huxinjian@jiuyescm.com
 */
public class EGMCacheAdapter implements ICacheAdapter {
    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit
        timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
