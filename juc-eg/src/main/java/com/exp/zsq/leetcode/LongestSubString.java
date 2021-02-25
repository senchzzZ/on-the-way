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
        //System.out.println(lengthOfLongestSubstring("pwwkewr"));
        //System.out.println(lengthOfLongestSubstring2("pwwkewr"));
        //System.out.println(lengthOfLongestSubstring3("pwwkewr"));
        //System.out.println(lengthOfLongestSubstring3("abcabcbb"));
        System.out.println(lengthOfLongestSubstring3("abcabcbadfeb"));
        //System.out.println(System.nanoTime() - timestamp);

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
                subStr = subStr.substring(subMode + 1) + c;
                mode = subStr.length();
            }
            maxMode = Math.max(mode, maxMode);
        }

        return maxMode;
    }

    //pwwkewr
    static int lengthOfLongestSubstring2(String s) {
        int[] index = new int[128];
        int result = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            j = Math.max(index[s.charAt(i)], j);//shift to last index of the repeat charactor
            System.out.println("i:" + i + " j:" + j);
            result = Math.max(result, i - j + 1);
            System.out.println("result:" + result);
            index[s.charAt(i)] = i + 1;
        }
        return result;

    }

    //abcabcbadfeb
    static int lengthOfLongestSubstring3(String s) {
        int length = 0;
        int result = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            int pos = s.indexOf(s.charAt(i), j);//出现重复字符的位置
            System.out.println("pos:" + pos);
            if (pos < i) {
                /*if (length > result) {
                    result = length;
                }*/
                result =  Math.max(length, result);
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                j = pos + 1;
            }
            length++;
        }

        return length;
    }
}
