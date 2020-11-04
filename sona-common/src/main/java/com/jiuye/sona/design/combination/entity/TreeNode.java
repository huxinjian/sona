package com.jiuye.sona.design.combination.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:08
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class TreeNode {

    private Long treeId;

    private Long treeNodeId;

    private Integer nodeType;

    private String nodeValue;

    private String ruleKey;

    private String ruleDesc;

    private List<TreeNodeLink> treeNodeLinkList;
}
