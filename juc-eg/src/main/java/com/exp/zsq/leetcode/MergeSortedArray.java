package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * @author zhaoshengqi
 * @date 2021/3/18 9:35 上午
 */
public class MergeSortedArray {
    public static void main(String[] args) {

    }

    /**
     * 双指针向前简写版
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-- + --n;

        while (n >= 0) {
            nums1[i--] = m >= 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }

    /**
     * 时间复杂度 : O( (n + m)log(n + m) )
     * 空间复杂度 : O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    static void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针向前
     * 时间复杂度 : O(n + m)
     * 空间复杂度 : O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    static void merge3(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

    }
}
