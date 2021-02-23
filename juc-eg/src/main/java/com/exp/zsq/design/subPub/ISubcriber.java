package com.exp.zsq.design.subPub;

/**
 * @author zhaoshengqi
 * @date 2020/10/23 6:21 下午
 */
public interface ISubcriber<M> {
    public void subcribe(Event event);

    public void unSubcribe(Event event);

    public void update(String publisher, M message);
}
