package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
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
}
