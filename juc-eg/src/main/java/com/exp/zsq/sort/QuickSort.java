package com.exp.zsq.sort;

import java.util.Arrays;

/**
 * 快速排序 时间复杂度O(N*logN) log(N+1)~O(N2)
 * Created by zhaoshengqi on 2017/5/11.
 */
public class QuickSort {

    private static int mark = 0;

    /**
     * 辅助交换方法
     *
     * @param array
     * @param a
     * @param b
     */
    private static void swap(int[] array, int a, int b) {
        if (a != b) {
            int temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        }
    }

    /**
     * 新一轮分隔
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int partition(int array[], int low, int high) {
        int base = array[low];
        mark++;
        System.out.println("正在进行第" + mark + "轮分隔，区域：" + low + "-" + high);
        while (low < high) {
            while (low < high && array[high] >= base) {
                high--;
                System.out.println("从右往左找比" + base + "小的，指针变动：" + low + "-" + high);
            }
            swap(array, low, high);
            while (low < high && array[low] <= base) {
                low++;
                System.out.println("从左往右找比" + base + "大的，指针变动：" + low + "-" + high);
            }
            swap(array, low, high);
        }
        return low;
    }

    /**
     * 对数组进行快速排序，递归调用
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int[] quickSort(int[] array, int low, int high) {
        if (low < high) {

            int division = partition(array, low, high);
            quickSort(array, low, division - 1);
            quickSort(array, division + 1, high);
        }
        return array;
    }

    /**
     * { 3, 5, 2, 6, 2,1,20,44,55,23,69,234 }
     * { 3, 1, 2, 6, 2,5,20,44,55,23,69,234 }
     * { 3, 1, 2, 2, 6,5,20,44,55,23,69,234 }
     * @param array
     * @param low
     * @param high
     */
    static void quickSort2(int[] array, int low, int high){
        if (low > high)
            return;

        int base = array[low];
        int l = low, r = high;

        while (l < r) {
            while (l<r && array[r] >= base){
                r--;
            }

            while (l<r && array[l] <= base){
                l++;
            }
            swap(array,l,r);
        }
        array[low] = array[l];
        array[l] = base;
        quickSort2(array,low,l-1);
        quickSort2(array,l+1,high);

    }

    private static void quickSort1(int[] array, int low, int high) {
        if (low > high)
            return;

        int base = array[low];
        int left = low, right = high;
        mark++;
        System.out.println("正在进行第" + mark + "轮分隔，区域：" + left + "-" + right);
        while (left < right) {
            while (left < right && array[right] >= base) {
                right--;
                System.out.println("从右往左找比" + base + "小的，指针变动：" + left + "-" + right);
            }
            //swap(array, left, right);
            while (left < right && array[left] <= base) {
                left++;
                System.out.println("从左往右找比" + base + "大的，指针变动：" + left + "-" + right);
            }
            System.out.println("swap~~~");
            swap(array, left, right);
        }
        array[low] = array[left];
        array[left] = base;
        quickSort1(array, low, left - 1);
        quickSort1(array, left + 1, high);
    }

    /**
     * 快排序
     *
     * @param array
     * @return
     */
    public static int[] sort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    public static void sort1(int[] array) {
        quickSort1(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = { 3, 5, 2, 6, 2,1,20,44,55,23,69,234 };
        sort1(array);
        System.out.println("最终结果:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        /*int[] array1 = { 3, 5, 2, 6, 2,1,20,44,55,23,69,234 };
        int[] sorted = sort(array1);
        System.out.println("最终结果:");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println();*/
        /*System.out.println(binarySearch(sorted,20));
        System.out.println(Integer.toBinaryString(286));*/
    }

    public static int binarySearch(int[] array, int key){
        //Arrays.sort(array);
        int low = 0;
        int high = array.length-1;
        while (low <= high){
            int mid = (low + high) >>> 1;
            int midVal = array[mid];
            if (key > midVal){
                low = mid;
            } else if (key < midVal){
                high = mid;
            } else {
                return midVal;
            }

        }

        return 0;
    }

}
