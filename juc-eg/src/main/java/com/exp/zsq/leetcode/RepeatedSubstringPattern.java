package com.exp.zsq.leetcode;

/**
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 *
 * @author zhaoshengqi
 * @date 2020/8/24 5:04 下午
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("abcabc"));
    }

    static boolean repeatedSubstringPattern(String s) {
        if (s == null)
            return false;
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);

    }
}
