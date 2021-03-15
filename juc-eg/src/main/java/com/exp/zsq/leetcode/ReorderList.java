package com.exp.zsq.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/reorder-list/
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @author zhaoshengqi
 * @date 2021/3/15 3:05 下午
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        reorderList(l1);
        System.out.println(l1);
    }

    static void reorderList(ListNode head) {
        if (head == null)
            return;
        Deque<ListNode> deque = new LinkedList<>();
        for (ListNode node = head; node != null; node = node.next) {
            deque.addLast(node);
        }
        head = deque.pollFirst();
        while (!deque.isEmpty()) {
            head.next = deque.pollLast();
            head = head.next;
            if (!deque.isEmpty()) {
                head.next = deque.pollFirst();
                head = head.next;
            }
        }
        head.next = null;
    }
}
