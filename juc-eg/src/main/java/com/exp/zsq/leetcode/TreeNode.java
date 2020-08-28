package com.exp.zsq.leetcode;

import lombok.Data;

/**
 * @author zhaoshengqi
 * @date 2020/8/27 5:19 下午
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
