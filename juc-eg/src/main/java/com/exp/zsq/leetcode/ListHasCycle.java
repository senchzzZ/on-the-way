package com.exp.zsq.leetcode;

/**
 * @author zhaoshengqi
 * @date 2021/3/3 2:02 下午
 */
public class ListHasCycle {
    public static void main(String[] args) {

    }

    static boolean hasCycle(ListNode head){
        if (head == null || head.next == null)
            return false;

        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }
        return false;
    }
}
