package com.jiuye.sona.algorithm.linked.copyLink;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表的深拷贝
 *
 * @Author: xinjian.hu
 * @Date: 2020/10/21 18:20
 * @Email: huxinjian@jiuyescm.com
 */
public class CopyLinkedTest {

    /**
     * 深度拷贝链表
     *
     * @param head
     */
    public static RandomLinkedNode copyTest(RandomLinkedNode head) {
        Map<RandomLinkedNode, RandomLinkedNode> tempMap = new HashMap<>();
        RandomLinkedNode current = head;
        RandomLinkedNode result = null;
        // 赋值创建对象
        while(current != null) {
            tempMap.put(current, new RandomLinkedNode(current.val));
            current = current.next;
        }

        current = head;

        while(current != null) {
            tempMap.get(current).next = tempMap.get(current.next);
            tempMap.get(current).random = tempMap.get(current.random);
            current = current.next;
        }
        result = tempMap.get(head);
        return result;
    }

    /**
     * 链表深拷贝测试
     *
     * @param args
     */
    public static void main(String[] args) {
        RandomLinkedNode rNode3 = new RandomLinkedNode(6, null);
        RandomLinkedNode rNode2 = new RandomLinkedNode(3, rNode3);
        RandomLinkedNode rNode1 = new RandomLinkedNode(5, rNode2);
        rNode3.setRandom(rNode3);
        rNode2.setRandom(rNode1);
        rNode1.setRandom(rNode3);
        RandomLinkedNode result = copyTest(rNode1);

    }
}
