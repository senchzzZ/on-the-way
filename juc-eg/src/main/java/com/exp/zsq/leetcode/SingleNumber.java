package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * 找出只出现一次的数字
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author zhaoshengqi
 * @date 2021/3/19 2:29 下午
 */
public class SingleNumber {
    public static void main(String[] args) {

    }

    static int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i + 2) {
            if (i + 1 >= nums.length)
                return nums[i];
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 异或运算有以下三个性质。
     * <p>
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a = b⊕a⊕a = b⊕(a⊕a) = b⊕0 = b。
     *
     * 假设数组中有 2m+12m+1 个数，其中有 mm 个数各出现两次，一个数出现一次。令a1 a2 ... am为出现两次的 m 个数，
     * a(m+1)为出现一次的数。根据性质 3，数组中的全部元素的异或运算结果总是可以写成如下形式：
     * (a1⊕a1) ⊕ (a2⊕a2) ⊕ ... ⊕ (am⊕am)  ⊕ a(m+1)
     * 根据性质 2 和性质 1，上式可化简和计算得到如下结果：
     *  0 ⊕ 0 ⊕ ... 0 ⊕ a(m+1) = a(m+1)
     * @param nums
     * @return
     */
    static int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
