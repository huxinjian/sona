package com.jiuye.sona.design.combination;

import com.jiuye.sona.design.combination.entity.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:25
 * @Email: huxinjian@jiuyescm.com
 */
public abstract class BaseLogic implements LogicFilter {

    /**
     * 获取下一个节点
     *
     * @param matterValue 决策值
     * @param treeNodeLinkList 决策节点
     * @return 下一个节点id
     */
    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
        for(TreeNodeLink nodeLink : treeNodeLinkList) {
            if(decisionLogic(matterValue, nodeLink)) {
                return nodeLink.getNodeIdTo();
            }
        }
        return 0L;
    }

    /**
     * 获取决策值
     *
     * @param treeId
     * @param userId
     * @param decisionMatter 决策物料
     * @return
     */
    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);


    /**
     * 决策值比较方式
     *
     * @param matterValue
     * @param nodeLink
     * @return
     */
    private boolean decisionLogic(String matterValue, TreeNodeLink nodeLink) {

        switch (nodeLink.getRuleLimitType()){
            case 1:
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) <
                    Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) <=
                    Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) >=
                    Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;
        }

    }
}
