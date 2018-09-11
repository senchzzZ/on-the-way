package com.exp.zsq.leetcode;

/**
 * Created by zhaoshengqi on 2018/9/6.
 */
public class WaterContainer {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    static int maxArea(int[] height) {
        int length = height.length;
        int i = 0;
        int area = 0;
        int j = length - 1;
        while (j > i) {
            area = Math.max((j - i) * Math.min(height[i], height[j]), area);
            if (height[i] > height[j])
                j--;
            else
                i++;
        }
        return area;
    }
}
