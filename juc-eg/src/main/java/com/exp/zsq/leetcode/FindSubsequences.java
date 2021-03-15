package com.exp.zsq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [4,6,7,7,7]
 *
 * @author zhaoshengqi
 * @date 2020/8/25 9:13 上午
 */
public class FindSubsequences {

    public static void main(String[] args) {
        FindSubsequences f = new FindSubsequences();
        List<List<Integer>> result = f.findSubsequences(new int[]{4,6,7,7});
        System.out.println(result);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null)
            return null;
        dfs(0,Integer.MIN_VALUE, nums);
        return res;
    }

    private void dfs(int curIndex, int preValue, int[] nums) {
        if (curIndex >= nums.length) {
            if (temp.size() > 1) {
                res.add(new ArrayList<>(temp));
                System.out.println(temp);
            }
            return;
        }

        if (nums[curIndex] >= preValue) {
            System.out.println("~0: " + curIndex);
            temp.add(nums[curIndex]);
            dfs(curIndex + 1,nums[curIndex],nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[curIndex] != preValue) {   // 不遍历 重复元素
            System.out.println("~1: " + curIndex);
            dfs(curIndex + 1, preValue, nums);  // 将下一个元素加入，并向后遍历
        }

    }

}
