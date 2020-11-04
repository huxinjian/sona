package com.jiuye.sona.design.combination.entity;

import lombok.Data;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/30 15:48
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class EngineResult {

    private String userId;

    private Long treeId;

    private Long treeNodeId;

    private String treeNodeValue;

    public EngineResult() {
    }

    public EngineResult(String userId, Long treeId, Long treeNodeId, String treeNodeValue) {
        this.userId = userId;
        this.treeId = treeId;
        this.treeNodeId = treeNodeId;
        this.treeNodeValue = treeNodeValue;
    }
}
