package com.exp.zsq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * https://leetcode-cn.com/problems/spiral-matrix/
 *
 * @author zhaoshengqi
 * @date 2021/3/19 2:59 下午
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{8,9,4},{7,6,5}};
        int[][] matrix2 = {{1,2,3}};
        int[][] matrix3 = {{1},{2},{3}};
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder(matrix2));
        System.out.println(spiralOrder(matrix3));
        int[][] matrix4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix4));
        int[][] matrix5 = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(spiralOrder(matrix5));
    }

    static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return null;
        if (matrix.length == 1)
            return Arrays.stream(matrix[0]).boxed().collect(Collectors.toList());

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        List<Integer> res = new ArrayList<>();
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++)//左到右
                res.add(matrix[t][i]);
            if (++t > b) break;
            for (int i = t; i <= b; i++)//上到下
                res.add(matrix[i][r]);
            if (--r < l) break;

            for (int i = r; i >= l; i--)//右到左
                res.add(matrix[b][i]);
            if (--b < t) break;
            for (int i = b; i >= t; i--)//下到上
                res.add(matrix[i][l]);
            if (++l > r) break;
        }

        return res;
    }
}
