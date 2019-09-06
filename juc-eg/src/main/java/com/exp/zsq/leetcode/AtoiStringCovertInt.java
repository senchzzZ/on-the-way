package com.exp.zsq.leetcode;

/**
 * -42  -> 42
 * +-42 -> 42
 * abc42 -> 0
 * "   32" -> 32
 * Created by zhaoshengqi on 2019/6/17.
 */
public class AtoiStringCovertInt {

    public static void main(String[] args) {

        System.out.println(myAtoi("-2asdsad"));
    }

    public static int myAtoi(String str) {
        String s = "";
        try {
            if (str == null || str.equals(""))
                return 0;
            str = str.trim();
            if (str.startsWith("-")){
                s += "-";
                str = str.replaceFirst("-","");
            } else if (str.startsWith("+"))
                str = str.replaceFirst("\\+","");

            for (int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                int si = c - '0';

                if (si > 9 || si < 0)
                    return s == "" || s.equals("-") ? 0 :Integer.valueOf(s);

                s += c;
            }

            return s.equals("-") || s == "" ? 0 : Integer.valueOf(s);

        } catch (NumberFormatException e) {
            if (s.startsWith("-"))
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }
}
