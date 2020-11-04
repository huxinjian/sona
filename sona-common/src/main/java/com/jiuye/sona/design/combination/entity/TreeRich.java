package com.jiuye.sona.design.combination.entity;

import lombok.Data;

import java.util.Map;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:52
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class TreeRich {

    private TreeRoot treeRoot;

    private Map<Long, TreeNode> treeNodeMap;

    public TreeRich(TreeRoot treeRoot, Map<Long, TreeNode> treeNodeMap) {
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
    }
}
