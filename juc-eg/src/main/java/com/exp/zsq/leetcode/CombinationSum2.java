package com.exp.zsq.leetcode;

import java.util.*;

/**
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * @author zhaoshengqi
 * @date 2020/9/10 9:25 上午
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 solution = new CombinationSum2();
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0)
            return res;

        Deque<Integer> queue = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates,0,res, target, queue);

        return res;
    }

    public void dfs(int[] candidates, int index, List<List<Integer>> res, int target, Deque<Integer> queue){

        if (target == 0) {
            res.add(new ArrayList<>(queue));
            return;
        }

        //[1,1,2,5,6,7,10] 8
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            queue.addLast(candidates[i]);
            dfs(candidates, i + 1, res, target - candidates[i], queue);
            queue.removeLast();
        }

    }
}
