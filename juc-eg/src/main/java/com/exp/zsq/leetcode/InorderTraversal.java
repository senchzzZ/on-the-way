package com.exp.zsq.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 * @author zhaoshengqi
 * @date 2020/9/14 9:11 上午
 */
public class InorderTraversal {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(res,root);
        return res;
    }

    void dfs(List<Integer> res, TreeNode root){
        if (root == null)
            return;
        dfs(res, root.left);

        res.add(root.val);
        dfs(res, root.right);

    }

    /**
     * stack
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }

        return res;
    }
}
