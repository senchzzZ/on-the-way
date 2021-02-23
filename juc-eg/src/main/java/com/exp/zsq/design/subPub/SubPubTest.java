package com.exp.zsq.design.subPub;

/**
 * @author zhaoshengqi
 * @date 2020/10/23 6:30 下午
 */
public class SubPubTest {
    public static void main(String[] args) {
        Event<String> event = new Event<>("事件");
        IPublisher<String> publisher1 = new Publisher<>("发布者1");
        ISubcriber<String> subcriber1 = new Subcriber<>("订阅者1");
        ISubcriber<String> subcriber2 = new Subcriber<>("订阅者2");
        subcriber1.subcribe(event);
        subcriber2.subcribe(event);
        publisher1.publish(event, "welcome", true);
        publisher1.publish(event, "to", true);
        publisher1.publish(event, "yy", false);
    }
}
