package com.jiuye.sona.design.combination;

import com.jiuye.sona.design.combination.entity.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 树节点逻辑过滤接口
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:02
 * @Email: huxinjian@jiuyescm.com
 */
public interface LogicFilter {

    /**
     * 逻辑决策器(获取下一个节点)
     *
     * @param matterValue 决策值
     * @param treeNodeLinkList 决策节点
     * @return 下一个节点id
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    /**
     * 获取决策值
     *
     * @param treeId
     * @param userId
     * @param decisionMatter 决策物料
     * @return 决策值
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);
}
