package com.jiuye.sona.algorithm.linked;

import javax.xml.soap.Node;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/20 15:22
 * @Email: huxinjian@jiuyescm.com
 */
public class LinkedOpera {

    /**
     * 简单的链表逆序
     *
     * @param node
     */
    public static void reverse(LinkedNode node){
        LinkedNode newNode = null;
        while(node != null) {
            LinkedNode next = node.next;
            node.next = newNode;
            newNode = node;
            node = next;
        }

        while(newNode != null) {
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

        while(--m > 0) {
            preHead = head;
            head = head.next;
        }

        LinkedNode modifyListTail = head;
        LinkedNode newHead = null;
        while(reverseLength > 0) {
            LinkedNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
            reverseLength--;
        }

        modifyListTail.next = head;
        if(preHead != null) {
            preHead.next = newHead;
        } else {
            result = newHead;
        }

        while(result != null) {
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
        while (current !=null) {
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
        while(result != null) {
            System.out.println("拆分后的结果是：" + result.val);
            result = result.next;
        }
    }


    public static void main(String[] args) {
//        LinkedNode node5 = new LinkedNode(5, null);
//        LinkedNode node4 = new LinkedNode(4, node5);
//        LinkedNode node3 = new LinkedNode(3, node4);
//        LinkedNode node2 = new LinkedNode(2, node3);
//        LinkedNode node1 = new LinkedNode(1, node2);
//        reverseBetween(node1, 2,4);
        //reverse(node1);

        LinkedNode node5 = new LinkedNode(2, null);
        LinkedNode node4 = new LinkedNode(5, node5);
        LinkedNode node3 = new LinkedNode(1, node4);
        LinkedNode node2 = new LinkedNode(4, node3);
        LinkedNode node1 = new LinkedNode(3, node2);
        partition(node1, 3);
    }
}
