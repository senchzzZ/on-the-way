package com.exp.zsq.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhaoshengqi
 * @date 2020/8/31 9:15 上午
 */
public class CanVisitAllRooms {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(2));
        list.add(new ArrayList<>());
        list.add(List.of(1));
        //list.add(List.of(3,0,1));
        //list.add(List.of(1));
        //list.add(List.of(0));
        //list.add(new ArrayList<>());
        System.out.println(new CanVisitAllRooms().canVisitAllRooms(list));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int size = rooms.size();
        int num = 0;

        //todo 改为单个数字,用位表示,0未visit 1-visit,
        int n = 0;

        boolean[] vis = new boolean[size];
        vis[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            num++;
            int x = queue.poll();
            for (int i : rooms.get(x)) {
                if (!vis[i]) {
                    vis[i] = true;
                    queue.offer(i);
                }
            }
            //todo 判断n数字的每个位都为1(n+1肯定是2的幂,则n > 0 ? (n & (n - 1)) == 0),return true

            //todo 简单优化,判断vis是否全为true

        }
        return num == size;
    }
}
