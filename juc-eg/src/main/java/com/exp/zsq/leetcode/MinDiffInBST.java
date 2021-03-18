package com.exp.zsq.leetcode;


/**
 * 找到树的最小节点
 * @author zhaoshengqi
 * @date 2020/8/27 4:56 下午
 */
public class MinDiffInBST {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        t1.setLeft(t2);
        t1.setRight(t3);
        t2.setLeft(t4);
        t2.setRight(t5);
        System.out.println(new MinDiffInBST().minDiffInBST(t1));
    }

    int prev = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;

        minDiffInBST(root.left);

        min = Math.min(min, Math.abs(root.val - prev));
        prev = root.val;

        minDiffInBST(root.right);

        return min;
    }

}
