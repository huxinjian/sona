package com.jiuye.sona.algorithm.tree;

import com.alibaba.fastjson.JSON;

import java.util.Stack;
import java.util.Vector;

/**
 * @Author: xinjian.hu
 * @Date: 2021/4/2 14:45
 * @Email: huxinjian@jiuyescm.com
 */
public class TreeSumSolution {



    public static Stack<Stack<Integer>> pathSum(TreeNode tree, int sum){
        Stack<Stack<Integer>> result = new Stack<>();
        Stack<Integer> oneResult = new Stack<>();
        int pathSum = 0;
        preorder(tree, sum, pathSum, oneResult, result);
        return  result;

    }


    public static void preorder(TreeNode tree, int sum,int pathSum, Stack<Integer> oneResult, Stack<Stack<Integer>> result) {
        if(tree == null) {
            return;
        }
        pathSum += tree.value;
        oneResult.push(tree.value);
        if(tree.left == null && tree.right == null && pathSum == sum) {
            System.out.println(oneResult);
            Stack<Integer> integerStack = new Stack<>();
            for(Integer value : oneResult) {
                integerStack.push(value);
            }
            result.add(integerStack);
        }
        preorder(tree.left, sum, pathSum, oneResult, result);
        preorder(tree.right, sum, pathSum, oneResult, result);
        pathSum -= tree.value;
        oneResult.pop();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.value = 5;
        TreeNode firstRight = new TreeNode();
        firstRight.value = 8;
        TreeNode firstLeft = new TreeNode();
        firstLeft.value = 4;

        TreeNode secondLeft1 = new TreeNode();
        secondLeft1.value = 11;
        TreeNode secondLeft2 = new TreeNode();
        secondLeft2.value = 13;
        TreeNode secondRight2 = new TreeNode();
        secondRight2.value = 4;


        TreeNode thirdLeft1 = new TreeNode();
        thirdLeft1.value = 7;
        TreeNode thirdRight1 = new TreeNode();
        thirdRight1.value = 2;
        TreeNode thirdLeft3 = new TreeNode();
        thirdLeft3.value = 5;
        TreeNode thirdRight3 = new TreeNode();
        thirdRight3.value = 1;

        root.right = firstRight;
        root.left =firstLeft;
        firstLeft.left = secondLeft1;

        firstRight.left = secondLeft2;
        firstRight.right = secondRight2;

        secondLeft1.right = thirdRight1;
        secondLeft1.left = thirdLeft1;

        secondRight2.left = thirdLeft3;
        secondRight2.right = thirdRight3;


        Stack<Stack<Integer>> result = pathSum(root,22);
        System.out.println("返回结果 " + JSON.toJSONString(result));
    }
}
