package com.exp.zsq.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.function.BiFunction;

/**
 * Created by zhaoshengqi on 2017/8/9.
 * 1.8新增函数compute() 和 merge()测试
 */
public class ConcurrentHashMapComputeDemo {
    static  Map<String, Integer> count = new ConcurrentHashMap<>();
    static CountDownLatch endLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        count.put("b", 4);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                //Integer oldValue, newValue;
                for (int i = 0; i < 50; i++) {
                    count.compute("a", new BiFunction<String, Integer, Integer>() {
                        @Override
                        public Integer apply(String k, Integer v) {
                            return v == null ? 1 : v + 1;
                        }
                    });
                }
                endLatch.countDown();
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        try {
            endLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(count.compute("b", (k, v) -> {
            System.out.println(k + " --- " + v);
            return null;
        }));
        System.out.println(count.compute("a", (k, v) -> v == null ? 1 : v + 1));
        System.out.println("count = "+count);
    }


}
