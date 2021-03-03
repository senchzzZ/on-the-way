package com.exp.zsq.leetcode;

/**
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * @author zhaoshengqi
 * @date 2021/3/3 11:14 上午
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums) {
        if (nums == null)
            return 0;

        int sum = nums[0];
        int prev = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum,0);
            sum += nums[i];
            prev = Math.max(sum, prev);
        }
        return prev;
    }
    static int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
