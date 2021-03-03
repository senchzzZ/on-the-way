package com.exp.zsq.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * <p>
 * https://leetcode-cn.com/problems/decode-string/
 *
 * @author zhaoshengqi
 * @date 2021/3/3 2:34 下午
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isDigit('a'));

        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
    }

    static String decodeString(String s) {
        if (s == null || s.isEmpty())
            return null;
        StringBuilder res = new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        Deque<Integer> multi = new LinkedList<>();
        int num = 0;
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                multi.add(num);
                stack.add(res.toString());
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                int n = multi.pollLast();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack.pollLast());
                res.append(tmp);
            } else {
                res.append(c);
            }
        }

        return res.toString();
    }
}
