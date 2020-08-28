package com.exp.zsq.leetcode;

/**
 * Tn = Tn-1 + Tn-2 + Tn-3
 * @author zhaoshengqi
 * @date 2020/8/28 10:19 上午
 */
public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(new Tribonacci().tribonacci(5));
    }

    public int tribonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        int x = 0,y = 1,z = 1,sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = x + y + z;
            x = y;
            y = z;
            z = sum;
        }
        return sum;

    }
}
