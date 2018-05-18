package com.exp.zsq.juc.executor.forkjoin.crawler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import org.htmlparser.Parser;
import org.htmlparser.filters.LinkStringFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

/**
 * Created by zhaoshengqi on 2017/10/26.
 */
public class LinkFinderAction extends RecursiveAction {

    private String url;
    private LinkHandler cr;

    /**
     * Used for statistics
     */
    private static final long t0 = System.nanoTime();

    public LinkFinderAction(String url, LinkHandler cr) {
        this.url = url;
        this.cr = cr;
    }

    @Override
    public void compute() {
        if (!cr.visited(url)) {
            try {
                List<RecursiveAction> actions = new ArrayList<>();
                URL uriLink = new URL(url);
                Parser parser = new Parser(uriLink.openConnection());
                //NodeList list = parser.extractAllNodesThatMatch(new HasAttributeFilter("target","_blank"));
                NodeList list = parser.extractAllNodesThatMatch(new LinkStringFilter("www.id97.com/movie"));

                for (int i = 0; i < list.size(); i++) {
                    LinkTag extracted = (LinkTag) list.elementAt(i);

                    System.out.println(extracted.getLink());

                    if (!extracted.extractLink().isEmpty()
                            && !cr.visited(extracted.extractLink())) {

                        actions.add(new LinkFinderAction(extracted.extractLink(), cr));
                    }
                }
                cr.addVisited(url);

                if (cr.size() == 1500) {
                    System.out.println("Time for visit 1500 distinct links= " + (System.nanoTime() - t0));
                }

                //invoke recursively
                invokeAll(actions);
            } catch (Exception e) {
                e.printStackTrace();
                //ignore 404, unknown protocol or other server errors
            }
        }
    }
}