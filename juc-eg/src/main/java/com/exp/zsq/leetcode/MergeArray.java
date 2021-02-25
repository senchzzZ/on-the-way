package com.exp.zsq.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author zhaoshengqi
 * @date 2021/1/26 4:12 下午
 */
public class MergeArray {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();

        Collections.sort(intervals, Comparator.comparingInt(v -> v.start));

        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval R = res.get(res.size() - 1);
            Interval L = intervals.get(i);
            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            if (L.start <= R.end) {
                int start = Math.min(R.start, L.start);
                int end = Math.max(R.end, L.end);
                res.remove(res.size() - 1);
                res.add(new Interval(start, end));
            } else {
                res.add(L);
            }
        }
        return res;

    }
}
