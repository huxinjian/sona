package com.jiuye.sona.algorithm.BFSAndDFS;

import java.util.*;

/**
 * @Author: xinjian.hu
 * @Date: 2021/3/18 13:25
 * @Email: huxinjian@jiuyescm.com
 */
public class BfsAndDfs {


    /**
     * 树的广度优先遍历
     *
     * @param root
     * @return
     */
    public List<Integer> bfsSolution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.peek();
            Integer val = tree.val;
            result.add(val);
            if(tree.left != null) {
                queue.offer(tree.left);
            }
            if(tree.right != null) {
                queue.offer(tree.right);
            }
        }
        return  result;
    }

    /**
     * 树的深度优先
     *
     * @param root
     * @return
     */
    public List<Integer> dfsSolution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode tree =  stack.pop();
            Integer val = tree.val;
            result.add(val);
            if(tree.left != null) {
                stack.push(tree.left);
            }
            if(tree.right != null) {
                stack.push(tree.right);
            }
        }
        return  result;
    }


    /**
     * 递归遍历深度优先
     *
     * @param root
     */
    public void depthOrderTraversalWithRecursive(TreeNode root) {
        depthTraversal(root);
    }

    private void depthTraversal(TreeNode tn) {
        if (tn!=null) {
            System.out.print(tn.val+"  ");
            depthTraversal(tn.left);
            depthTraversal(tn.right);
        }
    }
}
