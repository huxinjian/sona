package com.jiuye.sona.design.combination.engine;

import com.jiuye.sona.design.combination.entity.EngineResult;
import com.jiuye.sona.design.combination.entity.TreeRich;

import java.util.Map;

/**
 * 决策树引擎接口
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:47
 * @Email: huxinjian@jiuyescm.com
 */
public interface IEngine {

    EngineResult process(final Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);
}
