package com.jiuye.sona.algorithm.linked;

import javax.xml.soap.Node;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/20 15:22
 * @Email: huxinjian@jiuyescm.com
 */
public class LinkedOpera {
    Stack stack = new Stack();

    Queue queue = new ArrayBlockingQueue(100);


    /**
     * 简单的链表逆序
     *
     * @param node
     */
    public static void reverse(LinkedNode node) {
        LinkedNode newNode = null;
        while (node != null) {
            LinkedNode next = node.next;
            node.next = newNode;
            newNode = node;
            node = next;
        }

        while (newNode != null) {
            System.out.println("倒序后的结果是：" + newNode.val);
            newNode = newNode.next;
        }
    }

    /**
     * 链表逆序
     *
     * @param head
     * @param m
     * @param n
     */
    public static void reverseBetween(LinkedNode head, int m, int n) {
        int reverseLength = n - m + 1;
        LinkedNode preHead = null;
        LinkedNode result = head;

        while (--m > 0) {
            preHead = head;
            head = head.next;
        }

        LinkedNode modifyListTail = head;
        LinkedNode newHead = null;
        while (reverseLength > 0) {
            LinkedNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            reverseLength--;
        }

        modifyListTail.next = head;
        if (preHead != null) {
            preHead.next = newHead;
        } else {
            result = newHead;
        }

        while (result != null) {
            System.out.println("倒序后的结果是：" + result.val);
            result = result.next;
        }

    }

    /**
     * 根据数划分链表（小于num放在左边，大于num放在右边）
     *
     * @param head
     * @param num
     */
    public static void partition(LinkedNode head, int num) {
        LinkedNode lessHead = new LinkedNode(-1);
        LinkedNode moreHead = new LinkedNode(-1);
        // lessHead的当前位置
        LinkedNode lessCurrent = lessHead;
        // moreHead的当前位置
        LinkedNode moreCurrent = moreHead;
        // head的当前位置
        LinkedNode current = head;
        LinkedNode result;
        while (current != null) {
            if (current.val < num) {
                lessCurrent.next = current;
                lessCurrent = lessCurrent.next;
            } else {
                moreCurrent.next = current;
                moreCurrent = moreCurrent.next;
            }
            current = current.next;
        }
        lessCurrent.next = moreHead.next;
        moreCurrent.next = null;
        result = lessHead.next;
        while (result != null) {
            System.out.println("拆分后的结果是：" + result.val);
            result = result.next;
        }
    }


    /**
     * 两个顺序链表合并
     *
     * @param aNode
     * @param bnode
     */
    public static void mergeNode(LinkedNode aNode, LinkedNode bnode) {
        LinkedNode aNodeCurrent = aNode;
        LinkedNode bNodeCurrent = bnode;
        LinkedNode mergeNode = new LinkedNode(0);
        LinkedNode mergeNodeCurrent = mergeNode;
        while (aNodeCurrent != null || bNodeCurrent != null) {
            if(aNodeCurrent != null && bNodeCurrent != null) {
                if (aNodeCurrent.val < bNodeCurrent.val) {
                    mergeNodeCurrent.next = aNodeCurrent;
                    aNodeCurrent = aNodeCurrent.next;
                } else if (aNodeCurrent.val >= bNodeCurrent.val) {
                    mergeNodeCurrent.next = bNodeCurrent;
                    bNodeCurrent = bNodeCurrent.next;
                }
            } else {
                if(aNodeCurrent == null) {
                    mergeNodeCurrent.next = bNodeCurrent;
                    bNodeCurrent = bNodeCurrent.next;
                }else if (bNodeCurrent == null) {
                    mergeNodeCurrent.next = aNodeCurrent;
                    aNodeCurrent = aNodeCurrent.next;
                }
            }
            mergeNodeCurrent = mergeNodeCurrent.next;
        }
        LinkedNode result = mergeNode.next;
        while (result != null) {
            System.out.println("合并后的结果是：" + result.val);
            result = result.next;
        }

    }


    public static void main(String[] args) {
        LinkedNode node5 = new LinkedNode(5, null);
        LinkedNode node4 = new LinkedNode(4, node5);
        LinkedNode node3 = new LinkedNode(3, node4);
        LinkedNode node2 = new LinkedNode(2, node3);
        LinkedNode node1 = new LinkedNode(1, node2);
        //reverseBetween(node1, 2,4);
        reverse(node1);

//        LinkedNode node5 = new LinkedNode(2, null);
//        LinkedNode node4 = new LinkedNode(5, node5);
//        LinkedNode node3 = new LinkedNode(1, node4);
//        LinkedNode node2 = new LinkedNode(4, node3);
//        LinkedNode node1 = new LinkedNode(3, node2);
        //partition(node1, 3);

        //a链表
        LinkedNode anode3 = new LinkedNode(6);
        LinkedNode anode2 = new LinkedNode(4, anode3);
        LinkedNode anode1 = new LinkedNode(2, anode2);
        // b链表
        LinkedNode bnode3 = new LinkedNode(7);
        LinkedNode bnode2 = new LinkedNode(5, bnode3);
        LinkedNode bnode1 = new LinkedNode(1, bnode2);
        // mergeNode(anode1, bnode1);

    }
}
