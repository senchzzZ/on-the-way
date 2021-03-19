package com.exp.zsq.leetcode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * https://leetcode-cn.com/problems/add-strings/
 *
 * @author zhaoshengqi
 * @date 2021/3/19 4:23 下午
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("165","87"));
    }

    static String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null)
            return "";
        if (num1 == null || num1.equals("0"))
            return num2;
        if (num2 == null || num2.equals("0"))
            return num1;

        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int num = 0;
            if (i >= 0)
                num += num1.charAt(i--) - '0';
            if (j >= 0)
                num += num2.charAt(j--) - '0';
            num += carry;

            sb.append(num % 10);
            carry = num / 10;
        }
        if (carry == 1)
            sb.append("1");
        return sb.reverse().toString();
    }
}
