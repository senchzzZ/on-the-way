package com.exp.zsq.leetcode;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author zhaoshengqi
 * @date 2020/8/21 5:08 下午
 */
public class RegexMatch {

    public static void main(String[] args) {
        /*System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aaa", "aaaa"));
        System.out.println(isMatch("aaa", "a*a"));
        System.out.println(isMatch("aaa", "a*aa"));
        System.out.println(isMatch("aaa", "a*aaa"));
        System.out.println(isMatch("aaa", "a*aaaa"));*/
        System.out.println(isMatch2("aaab", "a*ab"));
    }

    static boolean isMatch2(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        //判断s和p的首字符是否匹配，注意要先判断s不为空
        boolean headMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {//*的特殊处理
            //则分别对两种情况进行判断
            return isMatch2(s, p.substring(2)) ||
                    (headMatched && isMatch2(s.substring(1), p));
        } else if (headMatched) {
            return isMatch2(s.substring(1), p.substring(1));//继续向后匹配
        } else {
            return false;
        }
    }

    static boolean isMatch(String s, String p) {
        if (s.equals(p))
            return true;

        if (p.isEmpty())
            return s.isEmpty();

        char sc = s.charAt(0);
        char pc = p.charAt(0);

        //todo
        if (p.length() >= 2 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            } else {
                if (sc == pc || pc == '.') {
                    return isMatch(s.substring(1), p);
                } else {
                    return false;
                }
            }

        } else if (sc == pc || pc == '.') {
            return isMatch(s.substring(1), p.substring(1));
        }

        if (sc == pc || pc == '.') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (sc != pc) {
            if (p.length() >= 2 && p.charAt(1) == '*') {

                return isMatch(s, p.substring(2));
            } else {
                return false;
            }

        } else {
            return false;
        }

    }
}
