package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 *
 * 输入：[3,2,3]
 * 输出：3
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * https://leetcode-cn.com/problems/majority-element/
 * @author zhaoshengqi
 * @date 2021/3/15 2:39 下午
 */
public class MajorityElement {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

}
