package com.jiuye.sona.algorithm.huisu;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 八皇后
 *
 * @Author: xinjian.hu
 * @Date: 2021/5/26 17:57
 * @Email: huxinjian@jiuyescm.com
 */
public class EightQueen {


    public static List<String[][]> solveNQueens(int n) {

        String[][] location = new String[n][n];
        List<String[][]> result = new ArrayList<>();
        int[][] mark = new int[n][n];
        // 初始化棋盘和皇后的摆放的位置
        for(int i = 0;i < n; i++) {
            for(int j =0; j < n; j++) {
                mark[i][j] =  0;
                location[i][j]="?";
            }
        }
        generate(0, n, location, result, mark);
        return result;
    }

    /**
     *
     * @param k 表示完成了几个皇后的放置
     * @param n 整个棋盘大小
     * @param location 某次结果存储在location中
     * @param result 最终结果存储在result
     * @param mark 棋盘的记录数组
     */
    public static void generate(int k, int n, String[][] location, List<String[][]> result, int[][] mark) {
        // 棋盘大小和皇后数放置相同
        if(k == n) {
            // 如果相同则放入数组
            String[][] oneResult = cloneStringArray(location, n);
            result.add(oneResult);
            return;
        }
        // 此时可以看成皇后在同一纵坐标放置的位置
        for(int i = 0; i < n; i++) {
            // 如果此处未被标记证明可以放置皇后
            if (mark[k][i] == 0) {
                // 暂存一个棋盘快照
                int[][] tmp_mark = cloneIntArray(mark, n);
                // 皇后放置的位置
                location[k][i] = "Q";
                // 开始放置皇后并更新棋盘
                putDownQueen(k,i,mark);
                // 递归开始
                generate(k+1, n, location,result, mark);
                // 回溯到上个快照版本
                mark = cloneIntArray(tmp_mark, n);
                // 放置位置开始回溯
                location[k][i] = "?";
            }
        }

    }

    /**
     * 设置皇后,更新棋盘
     *
     * @param x 皇后的横坐标
     * @param y 皇后的纵坐标
     * @param mark 棋盘
     */
    public static void putDownQueen(int x, int y, int[][] mark){
        // 八个方向数组
        int[] dx = {-1,0,1,-1,1,-1,0,1};
        int[] dy = {-1,-1,-1,0,0,1,1,1};
        mark[x][y] =1;
        // 循环设置
        for(int i = 1; i <mark.length;i++) {
            for(int j = 0; j  < 8; j++) {
                int new_x = x + dx[j] * i;
                int nex_y = y + dy[j] * i;
                System.out.println("x= " + new_x + ", y=" + nex_y);
                if(new_x >= 0 && new_x < mark.length && nex_y >=0
                    && nex_y < mark.length) {
                    mark[new_x][nex_y] =1;
                }
            }
        }
        System.out.println(JSON.toJSONString(mark));
    }


    public static int[][] cloneIntArray(int[][] s, int n){
        int[][] d = new int[n][n];
        for(int i =0; i < s.length; i++){
            for(int j = 0; j < s[i].length; j++) {
                d[i][j] = s[i][j];
            }
        }
        return d;
    }

    public static String[][] cloneStringArray(String[][] s, int n){
        String[][] d = new String[n][n];
        for(int i =0; i < s.length; i++){
            for(int j = 0; j < s[i].length; j++) {
                d[i][j] = s[i][j];
            }
        }
        return d;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String[][]> result = solveNQueens(4);
        System.out.println("返回结果：" + JSON.toJSONString(result));
    }
}
