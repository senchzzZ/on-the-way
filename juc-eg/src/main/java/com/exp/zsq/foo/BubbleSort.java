package com.exp.zsq.foo;

import java.util.Arrays;
import java.util.Random;

/**
 * Author: zhaoshengqi
 * Date: 2019/12/4 下午5:37
 */
public class BubbleSort {
    public static void main(String[] args) {
        Random random = new Random(47);
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt();
        }

        sort(array);
        Arrays.stream(array).forEach(n -> System.out.print(n+","));
    }
    public static void sort(int[] a){

        for (int i = a.length - 1; i > 0; i--){
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
