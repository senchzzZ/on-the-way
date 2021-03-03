package com.exp.zsq.leetcode;

import java.util.Stack;

/**
 * 反转链表
 * @author zhaoshengqi
 * @date 2021/3/3 9:15 上午
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1, new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(list);
        ListNode result = new ReverseList().reverseList(list);
        System.out.println(result);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;

    }

}
