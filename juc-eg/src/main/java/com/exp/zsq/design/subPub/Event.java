package com.exp.zsq.design.subPub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhaoshengqi
 * @date 2020/10/23 6:22 下午
 */
public class Event<M> {
    //订阅器名称
    private String name;
    //订阅器队列容量
    final int QUEUE_CAPACITY = 20;
    //订阅器存储队列
    private BlockingQueue<Msg> queue = new ArrayBlockingQueue<Msg>(QUEUE_CAPACITY);
    //订阅者
    private List<ISubcriber> subcribers = new ArrayList<ISubcriber>();

    public Event(String name) {
        this.name = name;
    }

    public void publish(String publisher, M message, boolean isInstantMsg) {
        if (isInstantMsg) {
            update(publisher, message);
            return;
        }
        Msg<M> m = new Msg<M>(publisher, message);
        if (!queue.offer(m)) {
            update();
        }
    }

    public void subcribe(ISubcriber subcriber) {
        subcribers.add(subcriber);
    }

    public void unSubcribe(ISubcriber subcriber) {
        subcribers.remove(subcriber);
    }

    public void update() {
        Msg m = null;
        while ((m = queue.peek()) != null) {
            this.update(m.getPublisher(), (M) m.getMsg());
        }
    }

    public void update(String publisher, M Msg) {
        for (ISubcriber subcriber : subcribers) {
            subcriber.update(publisher, Msg);
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Msg<M> {
    private String publisher;
    private M msg;
}
