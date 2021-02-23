package com.exp.zsq.leetcode;

import java.util.*;

/**
 * 反转二叉树
 * @author zhaoshengqi
 * @date 2020/9/16 2:19 下午
 */
public class InvertTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9);
        t1.setLeft(t2);
        t1.setRight(t3);
        t2.setLeft(t4);
        t2.setRight(t5);
        t3.setLeft(t6);
        t3.setRight(t7);

        //new InvertTree().dfs(t1,new ArrayList<>());
        new InvertTree().dfs(t1);
        TreeNode.printTreeMid(t1);

    }

    public TreeNode invertTree(TreeNode root){
        if (root == null)
            return null;
        dfs(root);
        return root;
    }
    void dfs(TreeNode root){
        if (root == null)
            return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        dfs(root.left);
        dfs(root.right);
    }
}
