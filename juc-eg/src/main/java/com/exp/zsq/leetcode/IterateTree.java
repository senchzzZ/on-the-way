package com.exp.zsq.leetcode;

/**
 * @author zhaoshengqi
 * @date 2020/12/10 3:41 下午
 */
public class IterateTree {
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
        preOrder(t1);
        System.out.println("~~~~~~~~");

        midOrder(t1);
        System.out.println("~~~~~~~~");

        postOrder(t1);
        System.out.println("~~~~~~~~");
    }

    static void preOrder(TreeNode node){
        if (node == null)
            return;
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void midOrder(TreeNode node){
        if (node == null)
            return;
        midOrder(node.left);
        System.out.println(node.val);
        midOrder(node.right);
    }

    static void postOrder(TreeNode node){
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }
}
