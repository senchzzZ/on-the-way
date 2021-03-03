package com.exp.zsq.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * @author zhaoshengqi
 * @date 2021/3/3 9:36 上午
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        ListNode listNode = new MergeTwoLists().mergeTwoLists(l1,l2);
        ListNode listNode2 = new MergeTwoLists().mergeTwoLists2(l1,l2);
        System.out.println(listNode);
        System.out.println(listNode2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        List<Integer> list  = new ArrayList<>();
        for (ListNode head = l1; head != null; head = head.next) {
            list.add(head.val);
        }
        for (ListNode head = l2; head != null; head = head.next) {
            list.add(head.val);
        }
        Collections.sort(list, Comparator.comparingInt(v -> v));

        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        for (int v : list) {
            prev.next = new ListNode(v);
            prev = prev.next;
        }
        return preHead.next;
    }
    private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                prev.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                prev.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;
        return preHead.next;
    }
}
