package com.exp.zsq.leetcode;


/**
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by zhaoshengqi on 2018/9/4.
 */
public class LongestSubString {
    public static void main(String[] args) {
        long timestamp = System.nanoTime();
        System.out.println(lengthOfLongestSubstring2("pwwkewr"));
        System.out.println(System.nanoTime() - timestamp);

    }

    static int lengthOfLongestSubstring(String s) {
        if (s == null || s == "")
            return 0;
        if (s.length() == 1)
            return 1;
        int mode = 0;
        int maxMode = 0;
        String subStr = "";
        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i) + "";
            if (!subStr.contains(c)) {
                ++mode;
                subStr += c;
            } else {
                int subMode = subStr.indexOf(c);
                subStr = subStr.substring(subMode + 1, subStr.length()) + c;
                mode = subStr.length();
            }
            maxMode = Math.max(mode, maxMode);
        }

        return maxMode;
    }


    static int lengthOfLongestSubstring2(String s) {
        int[] index = new int[128];
        int result = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            j = Math.max(index[s.charAt(i)],j);//shift to last index of the repeat charactor
            result = Math.max(result,i - j + 1);
            index[s.charAt(i)] = i + 1;
        }
        return result;

    }
}
