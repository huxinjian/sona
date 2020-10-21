package com.jiuye.sona.algorithm.linked.copyLink;

import lombok.Data;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/21 18:12
 * @Email: huxinjian@jiuyescm.com
 */
@Data
public class RandomLinkedNode {

    /**
     * 值域
     */
     public int val;

    /**
     * 指向的随机节点
     */
    public RandomLinkedNode random;

    /**
     * 下一个节点
     */
    public  RandomLinkedNode next;

    public RandomLinkedNode() {
    }

    public RandomLinkedNode(int val, RandomLinkedNode random, RandomLinkedNode next) {
        this.val = val;
        this.random = random;
        this.next = next;
    }

    public RandomLinkedNode(int val) {
        this.val = val;
    }

    public RandomLinkedNode(int val, RandomLinkedNode next) {
        this.val = val;
        this.next = next;
    }
}
