package com.exp.zsq.leetcode;

import lombok.Data;

/**
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 *
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * @author zhaoshengqi
 * @date 2020/8/25 4:32 下午
 */
public class LongestUnivaluePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);
        root.setLeft(t2);
        root.setRight(t3);
        t2.setLeft(t4);
        t2.setRight(t5);
        t3.setLeft(t6);
        LongestUnivaluePath l = new LongestUnivaluePath();
        System.out.println(l.longestUnivaluePath(root));
    }

    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        int left = 0;
        int right = 0;
        if ((root.left != null && root.val == root.left.val)) {
            left = l+1;
        }
        if (root.right != null && root.val == root.right.val) {
            right = r+1;
        }

        res = Math.max(res, left + right);
        return Math.max(left,right);

    }

    @Data
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
