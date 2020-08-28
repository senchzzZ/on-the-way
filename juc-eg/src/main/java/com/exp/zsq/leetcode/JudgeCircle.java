package com.exp.zsq.leetcode;

/**
 * @author zhaoshengqi
 * @date 2020/8/28 9:14 上午
 */
public class JudgeCircle {

    public static void main(String[] args) {
        System.out.println(new JudgeCircle().judgeCircle("UDLRRL"));
    }

    public boolean judgeCircle(String moves) {
        if (moves == null)
            return false;

        int x = 0;
        int y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'L':
                    x-=1;
                    break;
                case 'R':
                    x+=1;
                    break;
                case 'D':
                    y-=1;
                    break;
                case 'U':
                    y+=1;
                default:
                    break;
            }
        }
        return x == 0 && y == 0;

    }
}
