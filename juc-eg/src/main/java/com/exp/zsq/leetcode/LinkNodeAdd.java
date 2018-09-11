package com.exp.zsq.leetcode;


/**
 * [2,4,3]
 * [5,6,4]
 * [9]
 * [1,9,9,9,9,9,9,9,9,9]
 * Created by zhaoshengqi on 2018/9/3.
 */
public class LinkNodeAdd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
        //ListNode l1 = new ListNode(5, null);

        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        //ListNode l2 = new ListNode(5, null);

        System.out.println(addNodeNumbers2(l1, l2));
        //System.out.println(2%10);


    }

    public static ListNode addNodeNumbers2(ListNode l1, ListNode l2) {
        ListNode x = l1, y = l2;
        ListNode node = new ListNode(0);
        ListNode shift = node;
        boolean needCarry = false;

        while (x != null || y != null){
            int t = (x != null ? x.val : 0) + (y != null ? y.val : 0);
            if (needCarry)
                t += 1;
            if (t > 9)
                needCarry = true;
            else
                needCarry = false;

            int r = t % 10;
            ListNode ln = new ListNode(r);
            shift.next = ln;
            shift = shift.next;

            if (x != null)
                x = x.next;
            if (y != null)
                y = y.next;
        }
        if (needCarry)
            shift.next = new ListNode(1);
        return node.next;
    }


    public static ListNode addNodeNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        String str1 = "", str2 = "";
        for (ListNode x = l1; x != null; x = x.next)
            str1 += x.val;

        for (ListNode y = l2; y != null; y = y.next)
            str2 += y.val;

        String str = "";
        boolean needCarry = false;

        for (int i = 0; i < (str1.length() > str2.length() ? str2.length() : str1.length()); i++) {
            int t = Integer.parseInt(str1.charAt(i) + "") + Integer.parseInt(str2.charAt(i) + "");
            if (needCarry)
                t += 1;
            if (t > 9)
                needCarry = true;
            else
                needCarry = false;

            str += t % 10;
        }
        if (str1.length() != str2.length()) {
            String strSub = str.length() == str1.length() ? str2.substring(str.length(), str2.length())
                    : str1.substring(str.length(), str1.length());
            for (int i = 0; i < strSub.length(); i++) {
                int t_sub = Integer.parseInt(strSub.charAt(i) + "");
                if (needCarry)
                    t_sub += 1;
                if (t_sub > 9)
                    needCarry = true;
                else
                    needCarry = false;
                str += t_sub % 10;
            }
        }
        if (needCarry)
            str += 1;

        ListNode node = new ListNode(Integer.parseInt(str.charAt(str.length() - 1) + ""));
        for (int i = str.length() - 2; i >= 0; i--) {
            ListNode ln = new ListNode(Integer.parseInt(str.charAt(i) + ""));
            ln.next = node;
            node = ln;
        }


        return node;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;

        StringBuffer sb1 = new StringBuffer(), sb2 = new StringBuffer();
        for (ListNode x = l1; x != null; x = x.next) {
            sb1.append(x.val);
        }
        for (ListNode y = l2; y != null; y = y.next) {
            sb2.append(y.val);
        }

        sb1.reverse();
        sb2.reverse();
        String str = String.valueOf(Long.parseLong(sb1.toString()) + Long.parseLong(sb2.toString()));
        ListNode node = new ListNode(Integer.parseInt(str.charAt(0) + ""));
        for (int i = 1; i < str.length(); i++) {
            ListNode ln = new ListNode(Integer.parseInt(str.charAt(i) + ""));
            ln.next = node;
            node = ln;
        }

        return node;
    }

    static class ListNode {
        int val;
        ListNode next;

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
}
