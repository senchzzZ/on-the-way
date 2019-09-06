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
        System.out.println(reverse(a));
    }

    static int reverse(int x) {
        try {
            boolean negative = false;
            String str = String.valueOf(x);
            if (str.contains("-")){
                negative = true;
                str = str.replace("-","");
            }
            StringBuilder s = new StringBuilder(str);

            StringBuilder s1 = s.reverse();
            if (negative)
                return Integer.valueOf("-" + s1.toString());
            return Integer.valueOf(s1.toString());
        } catch (NumberFormatException e){
            return 0;
        }

    }
}
