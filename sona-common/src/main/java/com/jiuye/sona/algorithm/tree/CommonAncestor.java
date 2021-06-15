package com.jiuye.sona.algorithm.tree;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 * @Author: xinjian.hu
 * @Date: 2021/6/15 16:09
 * @Email: huxinjian@jiuyescm.com
 */
public class CommonAncestor {


    /**
     * leecode 236. 二叉树的最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = null;
        boolean finish = false;
        Stack<TreeNode> path1 = new Stack<>();
        Stack<TreeNode> result1 = new Stack<TreeNode>();
        getPath(root, p, finish, path1, result1);

        finish = false;
        Stack<TreeNode> path2 = new Stack<>();
        Stack<TreeNode> result2 = new Stack<TreeNode>();
        getPath(root, q, finish, path2, result2);
        for (TreeNode treeNode1 : result1) {
            for (TreeNode treeNode2 : result2) {
                if (treeNode1 == treeNode2) {
                    result = treeNode1;
                }
            }
        }
        Thread.State
        return result;
    }

    /**
     * 获取路径
     *
     * @param root
     * @param targetNode
     * @param finish
     * @param path
     */
    public static void getPath(TreeNode root, TreeNode targetNode, boolean finish, Stack<TreeNode> path, Stack<TreeNode> result) {
        if (root == null || finish) {
            return;
        }
        path.push(root);
        if (root == targetNode) {
            copy(path, result);
            finish = true;
        }
        getPath(root.left, targetNode, finish, path, result);
        getPath(root.right, targetNode, finish, path, result);
        path.pop();
    }

    public static void copy(Stack<TreeNode> source, Stack<TreeNode> target){
        for(TreeNode num : source) {
            target.add(num);
        }
    }


    public static void main(String args[]) {
        TreeNode node10 = new TreeNode();
        node10.value = 1;
        TreeNode node9 = new TreeNode();
        node9.value = 5;
        TreeNode node8 = new TreeNode();
        node8.value = 2;
        TreeNode node7 = new TreeNode();
        node7.value = 7;

        TreeNode node6 = new TreeNode();
        node6.value = 4;
        node6.left = node9;
        node6.right = node10;

        TreeNode node5 = new TreeNode();
        node5.value = 13;

        TreeNode node4 = new TreeNode();
        node4.value = 11;
        node4.left = node7;
        node4.right = node8;

        TreeNode node3 = new TreeNode();
        node3.value = 8;
        node3.left = node5;
        node3.right = node6;

        TreeNode node2 = new TreeNode();
        node2.value = 4;
        node2.left = node4;

        TreeNode node1 = new TreeNode();
        node1.value = 5;
        node1.left = node2;
        node1.right = node3;
        TreeNode result = lowestCommonAncestor(node1, node5, node10);
        System.out.println("返回结果: " + JSON.toJSONString(result));
    }
}
