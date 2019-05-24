package com.exp.zsq.guava;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2019/5/24.
 */
public class GuavaExcutorTest {
    public static void main(String[] args) {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        ListenableFuture explosion = service.submit(new Callable() {

            @Override
            public String call() throws Exception {
                System.out.println("start call");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("end call");
                return "1234";
            }
        });

        Futures.addCallback(explosion, new FutureCallback<Object>() {
            @Override
            public void onSuccess(@Nullable Object o) {
                System.out.println("call execute done");
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("call execute failed");

            }
        }, service);

    }
}
