package com.jiuye.sona.algorithm.Heap;

import java.util.PriorityQueue;

/**
 * @Author: xinjian.hu
 * @Date: 2020/10/26 16:23
 * @Email: huxinjian@jiuyescm.com
 */
public class HeapTest {


    /**
     * 获取数组中第k大的值
     *
     * @param data
     * @param k
     * @return
     */
    public static Integer getDate(Integer[] data, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer num1, Integer num2) -> num1 - num2);
        for (int i = 0; i < data.length; i++) {
            if (queue.size() < k) {
                queue.offer(data[i]);
            } else {
                if (queue.peek() < data[i]) {
                    queue.poll();
                    queue.offer(data[i]);
                }
            }
        }
        return queue.poll();
    }


    public static void main(String[] args) {
        Integer[] data = new Integer[]{0, 1, 5, 4, 3, 2};
        Integer result =  getDate(data, 3);
        System.out.println(result);


    }
}
