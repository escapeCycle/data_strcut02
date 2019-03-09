package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 象棋问题
 *
 * 二维数组,车能上下左右移动,可以移动多次,遇到兵能吃掉,
 * 遇到主教不能再向前,遇到数组边界也不能向前,只能吃掉一个兵就折回,
 * 同一个方向不能连续吃,返回能给吃掉的兵的数量
 * @author tianhuan
 * @date 2019-03-09 19:40
 **/
public class LeetCode_999 {

    /**
     * 第一种解法
     * @param board
     * @return
     */
    public int numRookCaptures(char[][] board) {
        int sum = 0;
        int ra = 0;
        int rb = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    ra = i;
                    rb = j;
                }
            }
        }
        /*
            同行 左边
         */
        for (int m = rb; m >= 0; m--) {
            if (board[ra][m] == 'B') {
                break;
            } else if (board[ra][m] == 'p') {
                sum++;
                break;
            }
        }
        /*
            同行 右边
         */
        for (int m = rb; m < board[ra].length; m++) {
            if (board[ra][m] == 'B') {
                break;
            } else if (board[ra][m] == 'p') {
                sum++;
                break;
            }
        }

        /*
            同列 上边
         */
        for (int m = ra; m >= 0; m--) {
            if (board[m][rb] == 'B') {
                break;
            } else if (board[m][rb] == 'p') {
                sum++;
                break;
            }
        }
        /*
            同列 下边
         */
        for (int m = ra; m < board.length; m++) {
            if (board[m][rb] == 'B') {
                break;
            } else if (board[m][rb] == 'p') {
                sum++;
                break;
            }
        }

        return sum;
    }

    /**
     * 第二种解法
     * @param board
     * @return
     */
    public int numRookCaptures2(char[][] board) {
        int n = board.length, m = board[0].length, ans = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'R') {
                    for (int[] dir : dirs) {
                        int di = i, dj = j;
                        while (inBounds(di, dj, board) && board[di][dj] != 'B' && board[di][dj] != 'p') {
                            di += dir[0];
                            dj += dir[1];
                        }
                        if (inBounds(di, dj, board) && board[di][dj] == 'p')
                            ans++;
                    }

                    break;
                }
            }
        }

        return ans;
    }
    boolean inBounds(int x, int y, char[][] board){
        return (x >= 0 && y >= 0 && x <= board.length-1 && y <= board[0].length-1);
    }

    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        char c = board[1][3];
        int sum = new LeetCode_999().numRookCaptures2(board);
        System.out.println(sum);
    }
}
