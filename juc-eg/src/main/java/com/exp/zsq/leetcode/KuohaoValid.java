package com.exp.zsq.leetcode;

import java.util.Stack;

/**
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 输入：s = "{[]}"
 * 输出：true
 * @author zhaoshengqi
 * @date 2021/3/3 10:04 上午
 */
public class KuohaoValid {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([]{}"));
        System.out.println(isValid("{[]}"));
    }

    static boolean isValid(String s){
        if (s == null || s.isEmpty())
            return false;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
