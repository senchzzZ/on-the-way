package com.exp.zsq.leetcode;

/**
 * 321 -> 123
 * -321 -> -123
 * 120 -> 21
 * Created by zhaoshengqi on 2019/6/14.
 */
public class IntReverse {
    public static void main(String[] args) {
        int a = 1534236469;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(a));
        System.out.println(reverse2(a));
        System.out.println(reverse2(-14324));
    }

    static int reverse(int x) {
        try {
            boolean negative = false;
            String str = String.valueOf(x);
            if (str.contains("-")) {
                negative = true;
                str = str.replace("-", "");
            }
            StringBuilder s = new StringBuilder(str);

            StringBuilder s1 = s.reverse();
            if (negative)
                return Integer.parseInt("-" + s1.toString());
            return Integer.parseInt(s1.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    static int reverse2(int x) {
        if ((x >= 0 && x < 10) || (x <= 0 && x > -10))
            return x;
        long reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x/10;
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
            return 0;
        return (int) reverse;
    }
}
