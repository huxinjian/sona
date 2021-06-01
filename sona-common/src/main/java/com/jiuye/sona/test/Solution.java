package com.jiuye.sona.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: xinjian.hu
 * @Date: 2021/4/28 15:35
 * @Email: huxinjian@jiuyescm.com
 */
public class Solution {



    public static boolean solutionMethod1 (int c) {
        for(int a= 0; a*a < c; a++) {
           double b = Math.sqrt(c-a*a);
           if(b == (int)b) {
               return true;
           }
        }
        return false;
    }


    public static boolean solutionMethod2(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);

        while(left <= right) {
            long result = left*left + right* right;
            if(result < c) {
               left = left + 1;
            }else if(result > c) {
                right = right -1;
            }else if (result == c) {
                return true;
            }
        }
        return false;
    }


    public static void f(int[] a, int k) {
        if(k == a.length -1) {
            System.out.println(Arrays.toString(a));
            return;
        }

        for(int i = k; i < a.length; i++) {
            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
            f(a, k +1);

            temp = a[i];
            a[i] = a[k];
            a[k] = temp;
        }
    }



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    public static void main(String[] args) {
//        int[] a = new int[] { 1, 2, 3, 4};
//        f(a, 0);
        String a ="123";
        String b = a;
        a= "234";
        System.out.println("a=" + a +",b=" + b);



//        boolean result =  solutionMethod2(2);
//        System.out.println("返回结果：" + result);

    }
}
