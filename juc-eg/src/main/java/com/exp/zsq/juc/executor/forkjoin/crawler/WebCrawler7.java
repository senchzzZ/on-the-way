package com.exp.zsq.juc.executor.forkjoin.crawler;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by zhaoshengqi on 2017/10/26.
 */
public class WebCrawler7 implements LinkHandler {

    //收集符合条件的链接
    private final Collection<String> visitedLinks = Collections.synchronizedSet(new HashSet<String>());
    private String url;
    private ForkJoinPool mainPool;

    public WebCrawler7(String startingURL, int maxThreads) {
        this.url = startingURL;
        mainPool = new ForkJoinPool(maxThreads);
    }

    private void startCrawling() {
        mainPool.invoke(new LinkFinderAction(this.url, this));
    }

    @Override
    public void queueLink(String link) throws Exception {
        //入队
    }

    @Override
    public int size() {
        return visitedLinks.size();
    }

    @Override
    public void addVisited(String s) {
        visitedLinks.add(s);
    }

    @Override
    public boolean visited(String s) {
        return visitedLinks.contains(s);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        new WebCrawler7("https://blog.csdn.net/", 64).startCrawling();
    }
}
