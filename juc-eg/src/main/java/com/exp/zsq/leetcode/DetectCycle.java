package com.exp.zsq.leetcode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * @author zhaoshengqi
 * @date 2021/1/5 2:54 下午
 */
public class DetectCycle {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (fastPointer == slowPointer) {
                ListNode tmp = head;

                if (tmp == fastPointer)
                    return tmp;

                while (tmp != fastPointer) {
                    tmp = tmp.next;
                    fastPointer = fastPointer.next;
                    if (tmp == fastPointer)
                        return fastPointer;
                }

            }
        }

        return null;
    }
}
