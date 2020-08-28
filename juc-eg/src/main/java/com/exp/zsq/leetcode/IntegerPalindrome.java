package com.exp.zsq.leetcode;

/**
 * 判断一个数字是否为回文数字
 * @author zhaoshengqi
 * @date 2020/8/21 4:47 下午
 */
public class IntegerPalindrome {

    public static void main(String[] args) {

    }

    static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (s.length() == 1)
            return true;
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        if (sb.toString().equals(sb.reverse().toString()))
            return true;

        return false;
    }

    static boolean isPalindrome2(int x) {
        if (x < 10 && x >= 0)
            return true;
        if (x < 0 || x % 10 == 0)//负数或0结尾都不是
            return false;

        int reverse = 0;

        while (x > reverse) {
            reverse = reverse * 10 + (x % 10);
            x = x / 10;
        }

        return reverse  == x || (reverse / 10) == x;

    }
}
