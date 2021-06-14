package com.jiuye.sona.algorithm.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RouteSum {

    public static boolean HasPathSum(TreeNode root, int targetSum) {
        List<Stack> result  = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        bianli(root, targetSum, result, stack);
        System.out.println(JSON.toJSONString(result));
        if(result != null && result.size() > 0) {
            return true;
        }
        return false;
    }

   private static void bianli(TreeNode root, int targetSum, List<Stack> result, Stack<Integer> stack){

        if(root == null) {
            return;
        }
        if(root.right == null && root.left == null){
            int sum = 0;
            for(int a: stack){
                sum = sum + a;
            }
            if(sum == targetSum) {
                Stack<Integer> target = new Stack<>();
                copy(stack, target);
                result.add(target);
            }
        }
        stack.push(root.value);
        bianli(root.left, targetSum, result, stack);
        bianli(root.left,targetSum, result, stack);
        stack.pop();
    }

    public static void copy(Stack<Integer> source, Stack<Integer> target){
        for(Integer num : source) {
            target.add(num);
        }
    }



    public static void main(String[] args) {



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
        node2.left =node4;

        TreeNode node1 = new TreeNode();
        node1.value = 5;
        node1.left= node2;
        node1.right =node3;


        HasPathSum(node1, 22);
    }
}
