package com.exp.zsq.leetcode;

/**
 * @author zhaoshengqi
 * @date 2021/1/5 2:55 下午
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    public void add(ListNode ln) {
        this.next = ln;
    }

    @Override
    public String toString() {
        String result = "";
        for (ListNode ln = this; ln != null; ln = ln.next) {
            result += ln.val;
        }
        return result;
    }
}
