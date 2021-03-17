package com.exp.zsq.leetcode;

/**
 * 最长公共子序列 & 数组元素连线不相交
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * <p>
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * https://leetcode-cn.com/problems/uncrossed-lines/
 * @author zhaoshengqi
 * @date 2021/3/16 4:22 下午
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "aec"));
    }

    //动态规划
    static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (n == 0 || m == 0)
            return 0;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[m][n];
    }

    //数组元素连线不相交
    static int longestCommonSubsequence2(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        if (n == 0 || m == 0)
            return 0;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i] == arr2[j])
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[m][n];
    }
}
