package com.exp.zsq.leetcode;

import java.util.*;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * @author zhaoshengqi
 * @date 2020/9/11 10:11 上午
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 solution = new CombinationSum3();
        List<List<Integer>> res = solution.combinationSum3(3, 9);
        System.out.println("输出 => " + res);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        int[] candidates = {1,2,3,4,5,6,7,8,9};
        Deque queue = new LinkedList();
        dfs(candidates, 0, n, res, queue, k);
        return res;
    }

    //[1,2,3,4,5,6,7,8,9]
    public void dfs(int[] candidates, int idx, int target, List<List<Integer>> res, Deque<Integer> queue, int k){
        if (target == 0 && queue.size() == k) {
            res.add(new ArrayList<>(queue));
            return;
        }
        if (queue.size() >= k)
            return;

        for (int i = idx; i < candidates.length; i++) {
            if (target - candidates[i] < 0)
                continue;
            queue.addLast(candidates[i]);
            dfs(candidates, i+1, target - candidates[i], res, queue, k);
            queue.removeLast();
        }
    }
}
