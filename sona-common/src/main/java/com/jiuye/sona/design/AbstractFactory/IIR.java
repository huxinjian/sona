package com.jiuye.sona.design.AbstractFactory;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author: xinjian.hu
 * @Date: 2020/9/22 15:16
 * @Email: huxinjian@jiuyescm.com
 */
public class IIR {

    private static final Logger log = LoggerFactory.getLogger(IIR.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        log.info("IIR获取数据,key{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        log.info("IIR存储数据,key{},value{}", key, value);
        dataMap.put(key,value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit
        timeUnit) {
        dataMap.put(key,value);
    }

    public void del(String key) {
        log.info("IIR删除数据,key{}", key);
        dataMap.remove(key);
    }
}
