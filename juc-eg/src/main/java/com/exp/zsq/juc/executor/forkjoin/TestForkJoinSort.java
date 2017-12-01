package com.exp.zsq.juc.executor.forkjoin;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by zhaoshengqi on 2017/10/30.
 */
class SortTask extends RecursiveAction {
    final long[] array;
    final int lo;
    final int hi;
    private int THRESHOLD = 2; //For demo only

    public SortTask(long[] array) {
        this.array = array;
        this.lo = 0;
        this.hi = array.length - 1;
    }

    public SortTask(long[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    protected void compute() {
        //System.out.println(getPool().toString());
        if (hi - lo < THRESHOLD)
            sequentiallySort(array, lo, hi);
        else {
            int pivot = partition(array, lo, hi);
            //int pivot = hi >>> 1;
            System.out.println("\npivot = " + pivot + ", low = " + lo + ", high = " + hi);
            //System.out.println("array" + Arrays.toString(array));
            invokeAll(new SortTask(array, lo, pivot - 1), new SortTask(array,
                    pivot + 1, hi));
        }
    }

    private int partition(long[] array, int lo, int hi) {
        long x = array[hi];//最高位值
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (array[j] <= x) {
                i++;
                if (i != j)
                    swap(array, i, j);
            }
        }
        swap(array, i + 1, hi);
        System.out.println("\npartition , array = "+Arrays.toString(array)+",pivot = "+(i+1));
        return i + 1;
    }

    private void swap(long[] array, int i, int j) {
        if (i != j) {
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private void sequentiallySort(long[] array, int lo, int hi) {
        System.out.println("\nsequentiallySort,array = "+Arrays.toString(array)+",low = "+lo+",high = "+hi);
        Arrays.sort(array, lo, hi + 1);
    }
}

public class TestForkJoinSort {
    private static final int NARRAY = 16; //For demo only
    long[] array = new long[NARRAY];
    Random rand = new Random();

    @Before
    public void setUp() {
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextLong()%100; //For demo only
        }
        System.out.println("Initial Array: " + Arrays.toString(array));
    }

    @org.junit.Test
    public void testSort() throws Exception {
        ForkJoinTask sort = new SortTask(array);
        //ForkJoinPool fjpool = new ForkJoinPool(4);
        ForkJoinPool fjpool = ForkJoinPool.commonPool();
        fjpool.submit(sort);
        //System.out.println(fjpool.toString());
        fjpool.shutdown();

        fjpool.awaitTermination(30, TimeUnit.SECONDS);

        System.out.println(Arrays.toString(array));

        assertTrue(checkSorted(array));
    }

    //@Test
    public void test2(){
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

    }

    boolean checkSorted(long[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > (a[i + 1])) {
                return false;
            }
        }
        return true;
    }
}
