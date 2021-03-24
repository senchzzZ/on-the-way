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
        System.out.println(countSubstrings("aaaa"));
    }


    static int solution(String str) {
        if (str == null)
            return 0;
        int sum = 0;
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            //奇
            int lo = i;
            int ro = i;
            while (lo >= 0 && ro < chars.length && chars[lo] == chars[ro]) {
                sum++;
                --lo;
                ++ro;
            }
            //偶
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

    /**
     * 中心扩展
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    static int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; ++i) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                --l;
                ++r;
                ++ans;
            }
        }
        return ans;
    }

}
