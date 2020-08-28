package com.exp.zsq.leetcode;

/**
 * @author zhaoshengqi
 * @date 2020/8/24 5:04 下午
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {

    }

    static boolean repeatedSubstringPattern(String s){
        if (s == null)
            return false;
        return (s + s).substring(1, s.length()*2-1).contains(s);

    }
}
