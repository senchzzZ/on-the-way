package com.exp.zsq.leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @author zhaoshengqi
 * @date 2021/3/16 10:05 上午
 */
public class ReverseBetweenList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        System.out.println(l1);
        ListNode res = reverseBetween(l1, 2, 4);
        System.out.println(res);
    }

    static ListNode reverseBetween(ListNode head,int left, int right){
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;//开始反转
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return node.next;

    }
}
