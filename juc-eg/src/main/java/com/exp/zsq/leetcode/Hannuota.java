package com.exp.zsq.leetcode;

import java.util.List;

/**
 * @author zhaoshengqi
 * @date 2020/8/28 2:00 下午
 */
public class Hannuota {
    public static void main(String[] args) {

    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        if (A == null || A.isEmpty())
            return;
        helper(A.size(), A,B,C);

    }

    void helper(int num, List<Integer> l1,List<Integer> l2, List<Integer> l3){
        if (num == 1) {
            l3.add(l1.remove(l1.size() - 1));
            return;
        }

        helper(num - 1, l1, l3, l2);
        l3.add(l1.remove(l1.size() - 1));
        helper(num - 1, l2, l1, l3);

    }
}
