package com.exp.zsq.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @author zhaoshengqi
 * @date 2021/3/15 4:43 下午
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    /**
     * 时间On 空间On
     * @param nums
     * @return
     */
    static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
