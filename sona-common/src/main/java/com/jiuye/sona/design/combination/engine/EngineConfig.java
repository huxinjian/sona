package com.jiuye.sona.design.combination.engine;

import com.jiuye.sona.design.combination.LogicFilter;
import com.jiuye.sona.design.combination.UserAgeFilter;
import com.jiuye.sona.design.combination.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 决策节点配置
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:43
 * @Email: huxinjian@jiuyescm.com
 */
public class EngineConfig {

    Map<String, LogicFilter> logicFilterMap;

    {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        this.logicFilterMap = logicFilterMap;
    }
}
