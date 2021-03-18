package com.exp.zsq.leetcode;

/**
 * 最长公共前缀
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @author zhaoshengqi
 * @date 2021/3/18 9:25 上午
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight","fluent"};
        System.out.println(longestCommonPrefix(strs));
    }

    static String longestCommonPrefix(String[] strs){
        if (strs.length == 0)
            return "";

        String res = strs[0];
        for (String str : strs) {
            while (!str.startsWith(res)) {
                res = res.substring(0,res.length()-1);
            }
        }

        return res;
    }
}
