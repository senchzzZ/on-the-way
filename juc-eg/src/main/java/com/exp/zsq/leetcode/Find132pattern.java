package com.exp.zsq.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * <p>
 * 输入: [3, 1, 4, 2]
 * 输出: True
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * <p>
 * https://leetcode-cn.com/problems/132-pattern/
 *
 * @author zhaoshengqi
 * @date 2021/3/24 9:25 上午
 */
public class Find132pattern {
    public static void main(String[] args) {

    }


    /**
     * 枚举3,从左到右枚举3的下标j
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }

        // 左侧最小值
        int leftMin = nums[0];
        // 右侧所有元素
        TreeMap<Integer, Integer> rightAll = new TreeMap<>();

        for (int k = 2; k < n; ++k) {
            rightAll.put(nums[k], rightAll.getOrDefault(nums[k], 0) + 1);
        }

        for (int j = 1; j < n - 1; ++j) {
            if (leftMin < nums[j]) {
                Integer next = rightAll.ceilingKey(leftMin + 1);
                if (next != null && next < nums[j]) {
                    return true;
                }
            }
            leftMin = Math.min(leftMin, nums[j]);
            rightAll.put(nums[j + 1], rightAll.get(nums[j + 1]) - 1);
            if (rightAll.get(nums[j + 1]) == 0) {
                rightAll.remove(nums[j + 1]);
            }
        }

        return false;
    }

    public boolean find132pattern2(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return false;
        //min[i]表示 nums[0]到nums[i]的最小值
        int[] min = new int[n];
        min[0] = nums[0];// 第一个位置的最小数肯定就是它自己了
        // 将前一个位置的最小数和当前位置的数比较，找到当前位置的最小数
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[n - 1]);
        // 从后往前遍历，stack 中的数字表示的是从位置 i 到 n 中，大于 min[i] 且小于 nums[i] 的数
        for (int j = n - 2; j >= 1; j--) {
            if (nums[j] > min[j]) {
                // 如果栈中的数字比 min[i] 还小或者相同，那么说明不可能是 ak，就弹出来
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                //此时栈顶元素一定大于min[j]
                if (!stack.isEmpty() && nums[j] > stack.peek())
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

}
