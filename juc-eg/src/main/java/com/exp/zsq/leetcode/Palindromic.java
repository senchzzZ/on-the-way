package com.exp.zsq.leetcode;

/**
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Created by zhaoshengqi on 2018/9/4.
 */
public class Palindromic {
    public static void main(String[] args) {
        //System.out.println(longestPalindrome2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(longestPalindrome2(""));
        //System.out.println(longestPalindrome2("edaabcbaads"));
        //System.out.println("ababca".lastIndexOf(98));

    }

    static String longestPalindrome2(String s) {
        if (s.length() <= 1)
            return s;
        int low = 0, high = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean founded = true;
            int c = s.charAt(i);
            int li = s.lastIndexOf(c);
            int x = i;
            int y = li;
            while (y >= x) {
                if (s.charAt(x++) != s.charAt(y--)) {
                    if (li == s.indexOf(c, i + 1))
                        founded = false;
                    li = y = s.lastIndexOf(c, li - 1);
                    x = i;
                }
            }

            if (founded && (li - i + 1 > high - low)) {
                high = li;
                low = i;
            }
            if (high - low > s.length() - i)
                break;
        }
        return s.substring(low, high + 1);
    }

    static String longestPalindrome(String s) {
        if (s == null || s == "")
            return null;
        if (s.length() == 1)
            return s;
        String longestSubStr = "";

        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i) + "";
            for (int j = s.lastIndexOf(c); j >= i; ) {
                String subStr = s.substring(i, j + 1);
                String reverseStr = new StringBuffer(subStr).reverse().toString();
                if (reverseStr.equals(subStr) && subStr.length() > longestSubStr.length()) {
                    longestSubStr = subStr;
                    break;
                }
                j = s.lastIndexOf(c, j - 1);
            }
            if (longestSubStr.length() > (s.length() - i))
                break;

        }
        return longestSubStr;
    }
}
