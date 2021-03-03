package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * 输入：[1, 5, 2]
 * 输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。
 * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
 * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 *
 * https://leetcode-cn.com/problems/predict-the-winner/
 * @author zhaoshengqi
 * @date 2020/9/1 10:01 上午
 */
public class PredictTheWinner {

    public static void main(String[] args) {
        System.out.println(new PredictTheWinner().PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(new PredictTheWinner().PredictTheWinner(new int[]{1, 5, 233,7}));
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
