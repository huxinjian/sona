package com.jiuye.sona.design.AbstractFactory;

import com.jiuye.sona.common.HttpUtil.HttpClientUtil;
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
public class EGM {

    private static final Logger log = LoggerFactory.getLogger(EGM.class);

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key) {
        log.info("EGM获取数据,key{}", key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        log.info("EGM存储数据,key{},value{}", key, value);
        dataMap.put(key,value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit
        timeUnit) {
        dataMap.put(key,value);
    }

    public void delete(String key) {
        log.info("EGM删除数据,key{}", key);
        dataMap.remove(key);
    }
}
