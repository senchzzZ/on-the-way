package com.exp.zsq.juc.executor.forkjoin;

import java.util.concurrent.CountedCompleter;

/**
 * Created by zhaoshengqi on 2017/11/7.
 */
public class CountedCompleterForEach {


}

class ForEach<E> extends CountedCompleter<Void> {

    public static <E> void forEach(E[] array, MyOperation<E> op) {
        new ForEach<E>(null, array, op, 0, array.length).invoke();
    }

    final E[] array;
    final MyOperation<E> op;
    final int lo, hi;

    ForEach(CountedCompleter<?> p, E[] array, MyOperation<E> op, int lo, int hi) {
        super(p);
        this.array = array;
        this.op = op;
        this.lo = lo;
        this.hi = hi;
    }

    public void compute() { // version 1
        if (hi - lo >= 2) {
            int mid = (lo + hi) >>> 1;
            setPendingCount(2); // must set pending count before fork
            new ForEach(this, array, op, mid, hi).fork(); // right child
            new ForEach(this, array, op, lo, mid).fork(); // left child
        } else if (hi > lo)
            op.apply(array[lo]);
        tryComplete();
    }

    /*public void compute() { // version 2
      if (hi - lo >= 2) {
        int mid = (lo + hi) >>> 1;
        setPendingCount(1); // only one pending
        new ForEach(this, array, op, mid, hi).fork(); // right child
        new ForEach(this, array, op, lo, mid).compute(); // direct invoke
      }
      else {
        if (hi > lo)
          op.apply(array[lo]);
        tryComplete();
      }
    }*/

   /* public void compute() { // version 3
      int l = lo,  h = hi;
      while (h - l >= 2) {
        int mid = (l + h) >>> 1;
        addToPendingCount(1);
        new ForEach(this, array, op, mid, h).fork(); // right child
        h = mid;
      }
      if (h > l)
        op.apply(array[l]);
      propagateCompletion();
    }*/
}

class MyOperation<E> {
    void apply(E e) {

    }
}