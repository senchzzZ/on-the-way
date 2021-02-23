package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * [1,5,2]
 * [1, 5, 233, 7]
 * https://leetcode-cn.com/problems/predict-the-winner/
 * @author zhaoshengqi
 * @date 2020/9/1 10:01 上午
 */
public class PredictTheWinner {

    public static void main(String[] args) {

    }

    public boolean PredictTheWinner(int[] nums) {
        int l = 0,r = nums.length - 1;
        return dfs(l,r,nums) >= 0;
    }

    int dfs(int l, int r, int[] nums) {
        if (l == r)
            return nums[l];
        int p1 = nums[l] - dfs(l+1,r,nums);
        int p2 = nums[r] - dfs(l,r-1,nums);
        return Math.max(p1,p2);
    }
}
