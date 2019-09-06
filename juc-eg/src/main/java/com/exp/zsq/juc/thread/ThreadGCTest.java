package com.exp.zsq.juc.thread;

import org.apache.commons.collections4.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoshengqi on 2019/8/30.
 */
public class ThreadGCTest {

    public static void main(String[] args) {
        MyThread tg = new MyThread();
        for (int i = 0; i < 3; i++)
            tg.execute();
    }

    public static class MyThread{
        //休眠时间 500ms
        private static int DXS_DIAGNOSTIC_SLEEP_TIME = 500;

        private static Thread thread;
        public void execute() {

            thread = new Thread("DIAGNOSTIC_ANALYSIS_") {
                @Override
                public void run() {
                    doBusiness();
                }
            };
            thread.start();
        }

        /**关闭任务*/
        public void shutdown() {
            thread.interrupt();
        }

        private void doBusiness() {
            System.out.println("DIAGNOSTIC_ANALYSIS_TASK start...");
            try {
                //有红线的店列表
                List<Long> hotelIds = Arrays.asList(12345l);

                if(CollectionUtils.isEmpty(hotelIds)){
                    return;
                }
                for(;;){
                    if(Thread.currentThread().isInterrupted()){
                        //处理中断逻辑
                        System.out.println("DIAGNOSTIC_ANALYSIS_TASK interrupted...");
                        break;
                    }
                    byte[] arr = new byte[5*1024*1024];
                    TimeUnit.MILLISECONDS.sleep(DXS_DIAGNOSTIC_SLEEP_TIME);
                    System.out.println(arr);
                }

                System.out.println("DIAGNOSTIC_ANALYSIS_TASK end...");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        }
    }



}
