package com.jiuye.sona.design.AbstractFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/22 15:25
 * @Email: huxinjian@jiuyescm.com
 */
public class IIRCacheAdapter implements ICacheAdapter{


    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit
        timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}
