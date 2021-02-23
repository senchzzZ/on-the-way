package com.exp.zsq.design.subPub;

/**
 * @author zhaoshengqi
 * @date 2020/10/23 6:25 下午
 */
public class Publisher<M> implements IPublisher<M> {
    private String name;

    public Publisher(String name) {
        super();
        this.name = name;
    }

    public void publish(Event event, M msg, boolean isInstantMsg) {
        event.publish(this.name, msg, isInstantMsg);

    }
}
