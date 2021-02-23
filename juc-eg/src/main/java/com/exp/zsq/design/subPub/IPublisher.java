package com.exp.zsq.design.subPub;

/**
 * @author zhaoshengqi
 * @date 2020/10/23 6:20 下午
 */
public interface IPublisher<M> {
    void publish(Event event,M msg, boolean isInstantMsg);
}
