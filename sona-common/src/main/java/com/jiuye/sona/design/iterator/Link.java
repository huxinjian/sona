package com.jiuye.sona.design.iterator;

import lombok.Data;

/**
 * 树节点链路
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/10 14:56
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class Link {
    /**
     * 链路前一个节点（雇员id）
     */
    private String fromId;
    /**
     * 链路后一个节点（雇员id）
     */
    private String toId;

    public Link(String fromId, String toId) {
        this.fromId = fromId;
        this.toId = toId;
    }
}
