package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * Created by zhaoshengqi on 2018/9/3.
 */
public class MedianSolve {
    public static void main(String[] args) {
        int[] nums2 = //{};
                {1,2,5,9,10,20};
        int[] nums1 = //{1};
                {5,15,16,21};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null && nums2 == null) || (nums1.length == 0 && nums2.length == 0))
            return 0;

        double result = 0d;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums = new int[l1+l2];

        if (l1 == 0){
            nums = nums2;
        } else if (l2 == 0){
            nums = nums1;
        }else if (nums1[l1-1] <= nums2[0]){
            nums = Arrays.copyOf(nums1,l1+l2);
            System.arraycopy(nums2,0,nums,nums1.length,nums2.length);
        } else if (nums2[l2-1] <= nums1[0]){
            nums = Arrays.copyOf(nums2,l1+l2);
            System.arraycopy(nums1,0,nums,nums2.length,nums1.length);
        } else {//resort
            int i = nums1.length-1;
            int j = nums2.length-1;
            int writeIndex = nums.length-1;

            while (i >=0 && j >= 0)
                nums[writeIndex--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            while (i >= 0)
                nums[writeIndex--] = nums1[i--];
            while (j >=0)
                nums[writeIndex--] = nums2[j--];
        }

        if ((nums.length & 1) == 1) //odd
            result = nums[nums.length >> 1];
        else //even
            result = ((double)(nums[nums.length >> 1] + nums[(nums.length >> 1) - 1])) / 2;

        return result;
    }

    static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

}
