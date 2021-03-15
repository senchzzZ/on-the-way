package com.exp.zsq.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * https://leetcode-cn.com/problems/permutations/
 * @author zhaoshengqi
 * @date 2021/3/15 3:42 下午
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new Permute().permute(nums);
        System.out.println(res);
    }

    /**
     * 时间复杂度：O(n * n!)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int n = nums.length;
        dfs(n, 0, tmp, res);
        return res;
    }

    private void dfs(int n, int curr, List<Integer> tmp, List<List<Integer>> res) {
        if (curr == n) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = curr; i < n; i++) {
            // 动态维护数组
            Collections.swap(tmp, curr, i);
            // 继续递归填下一个数
            dfs(n,curr + 1, tmp, res);
            // 撤销操作
            Collections.swap(tmp, curr, i);
        }

    }

}
