package com.exp.zsq.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author zhaoshengqi
 * @date 2020/9/3 9:39 上午
 */
public class Solve8Queens {

    public static void main(String[] args) {
        List<List<String>> list = new Solve8Queens().solve8Queens();
        for (List<String> list1 : list) {
            for (String s : list1) {
                System.out.println(s);
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    int N = 8;          // 记录n
    char[][] board;     // 模拟棋盘
    List<List<String>> schemes = new LinkedList<>();    // 存放合法方案

    public List<List<String>> solve8Queens() {
        board = new char[N][N];
        for (char[] line : board) {     // 初始化
            Arrays.fill(line, '.');
        }
        backtrack(0);   // 从第 1 行开始放皇后
        return schemes;
    }

    public void backtrack(int r) {
        // 结束条件
        if (r == N) {
            // 添加方案
            List<String> scheme = Arrays.stream(board).map(String::valueOf).collect(Collectors.toList());

            //List<String> scheme = new LinkedList<>();
            /*for (char[] line : board) {
                scheme.add(String.valueOf(line));
            }*/
            schemes.add(scheme);
            return;
        }
        // 选择列表
        for (int j = 0; j < N; j++) {
            if (isValid(r, j)) {            // 合法才能选
                board[r][j] = 'o';          // 选择
                backtrack(r + 1);        // 往下一层搜索
                board[r][j] = '.';          // 撤销选择，以免影响同一行其他位置的摆放
            }
        }
    }

    public boolean isValid(int x, int y) {
        // 同一行
        for (int j = 0; j < y; j++) {
            if (board[x][j] == 'o') {
                return false;
            }
        }
        // 同一列
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'o') {
                return false;
            }
        }
        // 主对角线
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'o') {
                return false;
            }
        }
        // 副对角线
        for (int i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'o') {
                return false;
            }
        }
        return true;
    }
}
