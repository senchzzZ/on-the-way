package com.exp.zsq.leetcode;

/**
 * Created by zhaoshengqi on 2019/6/18.
 */
public class PalindromeJudge {
    public static void main(String[] args) {
        String str1 = new StringBuilder("i'm").append(" T").toString();
        System.out.println(str1.intern()==str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }

    public static boolean isPalindrome(int x) {

        return false;
    }
}
