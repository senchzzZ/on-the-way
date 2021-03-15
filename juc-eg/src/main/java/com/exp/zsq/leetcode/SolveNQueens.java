package com.exp.zsq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author zhaoshengqi
 * @date 2020/9/3 9:39 上午
 */
public class SolveNQueens {
    public static void main(String[] args) {

        System.out.println(new SolveNQueens().solveNQueens(8));
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        //初始化数组
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                chess[i][j] = '.';
        List<List<String>> res = new ArrayList<>();
        solve(res, chess, 0);
        return res;
    }

    private void solve(List<List<String>> res, char[][] chess, int row) {
        //终止条件，最后一行都走完了，说明找到了一组，把它加入到集合res中
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        //遍历每一行
        for (int col = 0; col < chess.length; col++) {
            //判断这个位置是否可以放皇后
            if (valid(chess, row, col)) {
                //数组复制一份
                char[][] temp = copy(chess);
                //在当前位置放个皇后
                temp[row][col] = 'Q';
                //递归到下一行继续
                solve(res, temp, row + 1);
            }
        }
    }

    //把二维数组chess中的数据测下copy一份
    private char[][] copy(char[][] chess) {
        char[][] temp = new char[chess.length][chess[0].length];
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[0].length; j++) {
                temp[i][j] = chess[i][j];
            }
        }
        return temp;
    }

    //row表示第几行，col表示第几列
    private boolean valid(char[][] chess, int row, int col) {
        //判断当前列有没有皇后,因为他是一行一行往下走的，
        //我们只需要检查走过的行数即可，通俗一点就是判断当前
        //坐标位置的上面有没有皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //把数组转为list
    private List<String> construct(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            path.add(new String(chess[i]));
        }
        return path;
    }

}
