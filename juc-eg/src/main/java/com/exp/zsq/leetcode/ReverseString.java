package com.exp.zsq.leetcode;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 链接：https://leetcode-cn.com/problems/reverse-string
 *
 * @author zhaoshengqi
 * @date 2021/3/19 2:49 下午
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o','w'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    static void reverseString(char[] s) {
        if (s.length == 1)
            return;
        for (int i = 0, j = s.length - 1; i < s.length/2; i++) {
            if (s[i] != s[j]) {
                char tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
            --j;
        }
    }
}
