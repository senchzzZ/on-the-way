package com.exp.zsq.juc.executor.forkjoin;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zhaoshengqi on 2017/11/7.
 */
public class CountedCompleterSeacher {
}

class Searcher<E> extends CountedCompleter<E> {
    final E[] array;
    final AtomicReference<E> result;
    final int lo, hi;

    Searcher(CountedCompleter<?> p, E[] array, AtomicReference<E> result, int lo, int hi) {
        super(p);
        this.array = array;
        this.result = result;
        this.lo = lo;
        this.hi = hi;
    }

    public E getRawResult() {
        return result.get();
    }

    public void compute() { // similar to ForEach version 3
        int l = lo, h = hi;
        while (result.get() == null && h >= l) {
            if (h - l >= 2) {
                int mid = (l + h) >>> 1;
                addToPendingCount(1);
                new Searcher(this, array, result, mid, h).fork();
                h = mid;
            } else {
                E x = array[l];
                if (matches(x) && result.compareAndSet(null, x))
                    quietlyCompleteRoot(); // root task is now joinable
                break;
            }
        }
        tryComplete(); // normally complete whether or not found
    }

    boolean matches(E e) {// return true if found
        if((Integer) e == 2) {
            return true;
        }
        return false;
    }

    public static <E> E search(E[] array) {
        return new Searcher<E>(null, array, new AtomicReference<E>(), 0, array.length).invoke();
    }
}