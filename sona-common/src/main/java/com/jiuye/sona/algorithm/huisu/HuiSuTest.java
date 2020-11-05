package com.jiuye.sona.algorithm.huisu;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @Author: xinjian.hu
 * @Date: 2020/11/5 14:02
 * @Email: huxinjian@jiuyescm.com
 */
public class HuiSuTest {


    public static List<List<Integer>> getCombineNumbs(List<Integer> data) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.size(); j++) {

                temp.add(data.get(j));
                result.add(new ArrayList<>(temp));

            }
            temp.clear();
        }
        result.add(new ArrayList<>());
        return result;
    }


    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        subsets(nums);
        for (List<Integer> arr : ans) {
            System.out.println("返回结果是：" + arr);
        }
//         List<Integer> data = Arrays.asList(1,2,3);
//         List<List<Integer>> result = getCombineNumbs(data);
//         System.out.println("返回结果是：" + JSON.toJSONString(result));
    }
}
