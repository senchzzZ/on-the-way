package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 *
 * @author zhaoshengqi
 * @date 2021/3/16 9:49 上午
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int[] m : matrix)
            System.out.println(Arrays.toString(m));
    }

    /**
     * 定义上下左右边界,依次填入
     * @param n
     * @return
     */
    static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++)
                mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++)
                mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--)
                mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--)
                mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;

    }
}
