package com.exp.zsq.leetcode;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoshengqi
 * @date 2020/8/27 5:19 下午
 */
@Data
@NoArgsConstructor
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public static void printTreeFront(TreeNode root) {
        if (root == null)
            return;

        System.out.println(root.val);
        printTreeFront(root.left);
        printTreeFront(root.right);
    }

    public static void printTreeMid(TreeNode root) {
        if (root == null)
            return;

        printTreeMid(root.left);
        System.out.println(root.val);
        printTreeMid(root.right);
    }

    public static void printTreeAfter(TreeNode root) {
        if (root == null)
            return;

        printTreeAfter(root.left);
        printTreeAfter(root.right);
        System.out.println(root.val);
    }
}
