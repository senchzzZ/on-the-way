package com.exp.zsq.thread;

/**
 * Created by zhaoshengqi on 2017/7/21.
 */
public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        Depot depot = new Depot(10);
        Producer p = new Producer(depot);
        Consumer c = new Consumer(depot);
        p.produce(20);
        c.consume(50);

        /*Thread.sleep(1000*60);
        Thread.currentThread().interrupt();*/
    }

}

class Depot{
    private int capacity;//容量
    private int leftNum;//剩余数量

    public Depot(int capacity){
        this.capacity=capacity;
        leftNum = 0;
    }

    public synchronized void produce(int val){
        try {
            //剩余数量
            int left = val;
            while (left>0){
                while (leftNum>=capacity)
                    wait();
                int proNum = leftNum+left > capacity ? capacity-leftNum : left;
                leftNum += proNum;
                left -= proNum;
                System.out.printf("%s produce(%3d) --> left=%3d, proNum=%3d, leftNum=%3d\n",Thread.currentThread().getName(), val, left, proNum, leftNum);
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume(int val){

        try {
            //剩余消费数
            int left = val;
            while (left>0){

                while (leftNum <= 0)
                    wait();
                int conNum = leftNum<left ? leftNum : left;
                leftNum -= conNum;
                left -= conNum;
                System.out.printf("%s consume(%3d) --> left=%3d, conNum=%3d, leftNum=%3d\n",Thread.currentThread().getName(), val, left, conNum, leftNum);
                notifyAll();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class Producer{
    private Depot depot;
    public Producer(Depot depot){
        this.depot = depot;
    }
    public void produce(int pro){
        new Thread(() -> {
            depot.produce(pro);
        }).start();
    }
}

class Consumer{
    private Depot depot;
    public Consumer(Depot depot){
        this.depot = depot;
    }

    public void consume(int con){
        new Thread(() -> {
            depot.consume(con);
        }).start();
    }

}