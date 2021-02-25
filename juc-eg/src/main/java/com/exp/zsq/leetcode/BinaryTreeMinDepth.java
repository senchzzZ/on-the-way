package com.exp.zsq.leetcode;


/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * @author zhaoshengqi
 * @date 2020/8/21 10:42 上午
 */
public class BinaryTreeMinDepth {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.setLeft(t2);
        t1.setRight(t3);
        t3.setLeft(t4);
        t3.setRight(t5);
        t2.setLeft(t6);
        t2.setRight(t7);
        System.out.println(t1);
        System.out.println(minDepth(t1));
    }

    static int minDepth(TreeNode root){
        if (root == null)
            return 0;

        TreeNode left = root.left,right = root.right;
        if (left == null && right == null)
            return 1;

        int m1 = minDepth(left);
        int m2 = minDepth(right);
        if (left == null || right == null)
            return m1 + m2 + 1;

        return Math.min(m1, m2) + 1;
    }

}
