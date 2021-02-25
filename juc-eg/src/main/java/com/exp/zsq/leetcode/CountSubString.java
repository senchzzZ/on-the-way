package com.exp.zsq.leetcode;

/**
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *  
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"
 *
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * @author zhaoshengqi
 * @date 2020/8/19 2:28 下午
 */
public class CountSubString {

    public static void main(String[] args) {

        System.out.println(solution("aaaa"));
        System.out.println(solution("aaabaaa"));
        System.out.println(solution1("aaaa"));
    }


    static int solution(String str) {
        if (str == null)
            return 0;
        int sum = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            int lo = i;
            int ro = i;
            while (lo >= 0 && ro < chars.length && chars[lo] == chars[ro]) {
                sum++;
                --lo;
                ++ro;
            }

            int le = i;
            int re = i+1;
            while (le >= 0 && re < chars.length && chars[le] == chars[re]) {
                sum++;
                --le;
                ++re;
            }
        }
        return sum;
    }

    static int solution1(String str){
        if (str == null || str.length() == 0)
            return 0;

        int sum = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++){
            int lo = i;
            int ro = i;
            while ((lo >= 0) && (ro < chars.length) && (chars[lo--] == chars[ro++])) {
                sum++;
            }
            int le = i;
            int re = i + 1;
            while ((le >= 0) && (re < chars.length) && (chars[le--] == chars[re++])) {
                sum++;
            }


        }

        return sum;
    }
}
