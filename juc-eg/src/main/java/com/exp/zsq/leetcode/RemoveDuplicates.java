package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * 删除重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author zhaoshengqi
 * @date 2021/3/19 10:48 上午
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,2,2,3,4,5,6,6,7,7,7,7,8};
        //int[] nums = {1,1,1};
        //int[] nums = {1,2,2};
        System.out.println(removeDuplicates(nums));
        Arrays.stream(nums).boxed().forEach(System.out::print);
    }

    static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1 || nums[0]== nums[nums.length-1])
            return 1;

        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                nums[++k] = nums[i];
            }

        }
        return k + 1;
    }


}
