package com.exp.zsq.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @author zhaoshengqi
 * @date 2021/3/3 10:53 上午
 */
public class ClimbStairs {

    static int climbStairs(int n){
        /**
         * 动态规划 类斐波那契数列
         * f(x)=f(x−1)+f(x−2)
         */
        //滚动数组 时间复杂度为 O(n) 渐进空间复杂度为 O(1)。
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
