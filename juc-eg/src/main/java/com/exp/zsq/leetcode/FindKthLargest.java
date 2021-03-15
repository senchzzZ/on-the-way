package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
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

    //O(log n) 二分法
    static int findKthLargest2(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) {//左边有序

                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;

    }
}
