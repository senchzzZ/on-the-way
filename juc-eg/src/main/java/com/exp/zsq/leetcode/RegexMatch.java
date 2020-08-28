package com.exp.zsq.leetcode;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author zhaoshengqi
 * @date 2020/8/21 5:08 下午
 */
public class RegexMatch {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("aaa", "aaaa"));
        System.out.println(isMatch("aaa", "a*a"));
        System.out.println(isMatch("aaa", "a*aa"));
        System.out.println(isMatch("aaa", "a*aaa"));
        System.out.println(isMatch("aaa", "a*aaaa"));
        // System.out.println(isMatch("aaab","a*ab"));
    }

    static boolean isMatch(String s, String p) {
        //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        /*if (p.isEmpty()) return s.isEmpty();
        //判断s和p的首字符是否匹配，注意要先判断s不为空
        boolean headMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {//如果p的第一个元素的下一个元素是*
            //则分别对两种情况进行判断
            return isMatch(s, p.substring(2)) ||
                    (headMatched && isMatch(s.substring(1), p));
        } else if (headMatched) {//否则，如果s和p的首字符相等
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return false;
        }*/

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
                    return isMatch(s.substring(1),p);
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

                return isMatch(s,p.substring(2));
            } else {
                return false;
            }

        } else {
            return false;
        }


        /*char[] chars = s.toCharArray();
        char[] ps = p.toCharArray();

        chars:
        for (int i = 0; i < chars.length; i++) {

            ps:
            for (int j = 0; j < ps.length; j++) {

                if (ps[j] == '*') {

                } else {
                    if (chars[i] == ps[j] || ps[j] == '.') {
                        continue chars;
                    }

                }


            }
        }


        for (int i = 0, j = 0; ; ) {
            if (j == ps.length && i == chars.length)
                return true;

            if ((j > ps.length - 1 && i < chars.length) || (i > chars.length - 1 && j < ps.length))//未全部匹配
                return false;

            if (ps[j] == '.' || chars[i] == ps[j]) {
                j++;
                i++;
                continue;
            }

            if (chars[i] != ps[j]) {

                if (ps[j] == '*') {
                    //向前判断
                    if (j - 1 >= 0 && (ps[j - 1] == '.' || chars[i] == ps[j - 1])) {
                        char c = chars[i];
                        while (++i < chars.length && chars[i] == c) {
                        }

                        j++;

                        continue;
                    } else {
                        j++;
                    }

                } else {
                    //向前判断


                    //向后判断,a*为0个的情况
                    if (++j < ps.length && ps[j] == '*') {
                        //i++;
                        j++;
                        continue;
                    } else {
                        return false;
                    }

                }
            }

        }*/

    }
}
