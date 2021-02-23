package com.exp.zsq.leetcode;

/**
 * @author zhaoshengqi
 * @date 2021/1/18 2:50 下午
 */
public class SuitableNumber {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,200,6,7,9,10,11,12,104,100,108,0};
        System.out.println(findSuitableNumber(arr,0, arr.length));
    }

    static int findSuitableNumber(int[] array, int low, int high){
        if (low < 0 || high > array.length) {//临界判断
            return 0;
        }
        int division = (low + high)/2;

        if (array[division] > array[division-1] && array[division] > array[division+1])
            return division;

        if (array[division + 1] > array[division]) {//右侧再分割
            return findSuitableNumber(array, division, high);
        } else if (array[division - 1] > array[division]) {
            return findSuitableNumber(array, low, division);//左侧再分割
        }
        return 0;
    }
}
