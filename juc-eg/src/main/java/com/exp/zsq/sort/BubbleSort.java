package com.exp.zsq.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 冒泡排序 时间复杂度O(n2)
 * Created by zhaoshengqi on 2017/5/19.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {6,4,3,7,8,2,1,2,23,34,67,86,21};
        sort(array);
        for (int a:array){
            System.out.print(a+",");

        }
    }
    public static void sort(int[] a){

        for (int i=a.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    swap(a,j,j+1);

                }
            }

        }
    }

    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
