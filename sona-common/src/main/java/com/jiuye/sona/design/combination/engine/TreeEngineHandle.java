package com.jiuye.sona.design.combination.engine;

import com.jiuye.sona.design.combination.entity.EngineResult;
import com.jiuye.sona.design.combination.entity.TreeNode;
import com.jiuye.sona.design.combination.entity.TreeRich;

import java.util.Map;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/30 16:24
 * @Email: huxinjian@jiuyescm.com
 */
public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMarker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        EngineResult engineResult = new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
        return engineResult;
    }
}
