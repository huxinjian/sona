package com.jiuye.sona.algorithm.linked;

import lombok.Data;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/20 15:18
 * @Email: huxinjian@jiuyescm.com
 */
public class LinkedNode {
    /**
     * 当前节点值
     */
    int val;
    /**
     * 当前节点指向的下一个节点
     */
    LinkedNode next;

    public LinkedNode(){}

    public LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }

    public LinkedNode(int val) {
        this.val = val;
    }

}
