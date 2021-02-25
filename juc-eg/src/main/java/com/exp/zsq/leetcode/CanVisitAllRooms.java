package com.exp.zsq.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 *
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
