package com.exp.zsq.leetcode;

/**
 * @author zhaoshengqi
 * @date 2020/8/20 9:35 上午
 */
public class Minesweeper {

    static int[][] sur = {{0,1},{0,-1},{1,-1},{1,0},{1,1},{-1,0},{-1,1},{-1,-1}};

    public static void main(String[] args) {

    }

    static char[][] updateBoard(char[][] board, int[] click) {

        if (board == null || click == null)
            return null;

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        } else { //E or 1~8
            dfs(board, x, y);
        }

        return board;
    }

    static void dfs(char[][] board, int x, int y){
        int count = 0;
        for (int d = 0; d < sur.length; d++) {
            int dx = x + sur[d][0];
            int dy = y + sur[d][1];
            if (dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length)
                continue;

            if (board[dx][dy] == 'M') {
                count ++;
            }
        }
        if (count > 0) {
            board[x][y] = (char) (count+'0');

        } else {
            board[x][y] = 'B';
            for (int d = 0; d < sur.length; d++) {
                int dx = x + sur[d][0];
                int dy = y + sur[d][1];
                if (dx < 0 || dy < 0 || dx >= board.length || dy >= board[0].length || board[dx][dy] != 'E')
                    continue;

                dfs(board, dx, dy);
            }

        }

    }
}
