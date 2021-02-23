package com.exp.zsq.design.subPub;

/**
 * @author zhaoshengqi
 * @date 2020/10/23 6:28 下午
 */
public class Subcriber<M> implements ISubcriber<M> {

    public String name;

    public Subcriber(String name) {
        super();
        this.name = name;
    }

    public void subcribe(Event event) {
        event.subcribe(this);
    }

    public void unSubcribe(Event event) {
        event.unSubcribe(this);
    }

    public void update(String publisher, M message) {
        System.out.println(this.name + "收到" + publisher + "发来的消息:" + message.toString());
    }
}
