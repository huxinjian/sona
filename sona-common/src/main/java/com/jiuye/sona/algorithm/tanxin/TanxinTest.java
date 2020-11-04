package com.jiuye.sona.algorithm.tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/26 17:57
 * @Email: huxinjian@jiuyescm.com
 */
public class TanxinTest {


    /**
     * 摇摆序列
     *
     * @param data
     * @return
     */
    public static int wiggleMaxLength(int[] data) {
        // 定义状态基
        final int BEGIN = 0;
        final int UP = 1;
        final int DOWN = 2;
        // 初始状态
        int state = BEGIN;
        // 最大长度
        int maxLength = 1;
        for (int i = 1; i < data.length; i++) {
            switch (state) {
                case BEGIN:
                    if (data[i - 1] < data[i]) {
                        state = UP;
                        maxLength++;
                    }
                    if (data[i - 1] > data[i]) {
                        state = DOWN;
                        maxLength++;
                    }
                    break;
                case UP:
                    if (data[i - 1] > data[i]) {
                        state = DOWN;
                        maxLength++;
                    }
                    break;
                case DOWN:
                    if (data[i - 1] < data[i]) {
                        state = UP;
                        maxLength++;
                    }
                    break;
            }
        }
        return maxLength;
    }


    /**
     * 跳跃游戏是否可达 力扣55
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            index.add(i + nums[i]);
        }
        int jump = 0;
        int maxIndex = 0;
        while (jump < index.size() && jump <= maxIndex) {
            if (maxIndex < index.get(jump)) {
                maxIndex = index.get(jump);
            }
            jump++;
        }
        if (jump == index.size()) {
            return true;
        }
        return false;
    }

    /**
     * 跳到终点，最少跳跃次数（leecode-45）
     *
     * @param nums
     * @return
     */
    public static int canJump3(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }

        int currentMaxIndex = nums[0];
        int preMaxIndex = nums[0];
        int jumpMin =1;

        for(int i = 1; i < nums.length; i++) {
            if(i > currentMaxIndex){
                jumpMin ++;
                currentMaxIndex = preMaxIndex;
            }
            if(preMaxIndex < nums[i] + i ) {
                preMaxIndex = nums[i] + i;
            }
        }

        return jumpMin;
    }


    public static void main(String[] args) {
//        int[] data = new int[]{1,17,5,10,13,15,10,5,16,8};
//        int maxLength = wiggleMaxLength(data);
//        System.out.println(maxLength);
        int[] data = new int[]{1,1,2,1,1};
        int count = canJump3(data);

        System.out.println("跳转次数为" + count);

    }


}

