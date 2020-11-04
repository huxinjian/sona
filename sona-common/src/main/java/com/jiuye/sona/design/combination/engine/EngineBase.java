package com.jiuye.sona.design.combination.engine;

import com.jiuye.sona.design.combination.LogicFilter;
import com.jiuye.sona.design.combination.entity.EngineResult;
import com.jiuye.sona.design.combination.entity.TreeNode;
import com.jiuye.sona.design.combination.entity.TreeRich;
import com.jiuye.sona.design.combination.entity.TreeRoot;

import java.util.Map;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:45
 * @Email: huxinjian@jiuyescm.com
 */
public abstract class EngineBase extends EngineConfig implements IEngine {

    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);


    protected TreeNode engineDecisionMarker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {

        TreeRoot treeRoot = treeRich.getTreeRoot();

        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 规则树根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();

        TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);
        //节点类型[NodeType]； 1⼦叶、 2果实
        while (treeNodeInfo.getNodeType().equals(1)) {
            String ruleKey = treeNodeInfo.getRuleKey();

            LogicFilter logicFilter = logicFilterMap.get(ruleKey);

            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);

            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
            treeNodeInfo = treeNodeMap.get(nextNode);

            System.out.println("决策树引擎=>{"+ treeRoot.getTreeName() +"} userId： {" + userId + "} treeId： {" +treeId+ "} treeNode： {" + treeNodeInfo.getTreeNodeId() + "} ruleKey： {" + ruleKey + "} matterValue： {" + matterValue + "}");
        }
        return treeNodeInfo;
    }
}
