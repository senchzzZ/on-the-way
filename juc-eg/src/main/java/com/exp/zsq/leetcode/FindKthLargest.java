package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * @author zhaoshengqi
 * @date 2021/3/3 3:29 下午
 */
public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums1 = {3,2,1,5,6,4};
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums1,2));
        System.out.println(findKthLargest(nums2,4));
    }

    static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k)
            return 0;

        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}
