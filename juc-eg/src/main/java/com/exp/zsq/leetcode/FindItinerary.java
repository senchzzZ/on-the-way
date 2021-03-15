package com.exp.zsq.leetcode;

import java.util.*;

/**
 * 示例 1：
 *
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 *
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 * @author zhaoshengqi
 * @date 2020/8/27 4:33 下午
 */
public class FindItinerary {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> l1 = List.of("MUC","LHR");
        List<String> l2 = List.of("JFK","MUC");
        List<String> l3 = List.of("SFO","SJC");
        List<String> l4 = List.of("LHR","SFO");
        List<String> l5 = List.of("LHR","MUC");
        tickets.add(l1);
        tickets.add(l2);
        tickets.add(l3);
        tickets.add(l4);
        tickets.add(l5);
        System.out.println(new FindItinerary().findItinerary(tickets));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        // 因为逆序插入，所以用链表
        List<String> ans = new LinkedList<>();
        if (tickets == null || tickets.size() == 0)
            return ans;
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            // 因为涉及删除操作，我们用链表
            graph.computeIfAbsent(pair.get(0), k -> new LinkedList<>()).add(pair.get(1));
        }
        // 按目的顶点排序
        graph.values().forEach(x -> x.sort(String::compareTo));
        visit(graph, "JFK", ans);
        return ans;
    }
    // DFS方式遍历图，当走到不能走为止，再将节点加入到答案
    private void visit(Map<String, List<String>> graph, String src, List<String> ans) {
        List<String> nbr = graph.get(src);
        while (nbr != null && nbr.size() > 0) {
            String dest = nbr.remove(0);
            visit(graph, dest, ans);
        }
        ans.add(0, src); // 逆序插入
    }

}
