package com.xunhuan.java.algorithm.sword_offer;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * <p>
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * @author tianhuan
 * @date 2019-04-19 14:41
 **/
public class Sword_4 {

    public boolean find(int target, int[][] matrix) {
        if (matrix == null) return false;
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        int t = 0, l = cols - 1;
        while (t <= rows - 1 && l >= 0) {
            if (matrix[t][l] == target) {
                return true;
            } else if (target < matrix[t][l]) {
                l--;
            } else {
                t++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        Sword_4 sword_4 = new Sword_4();
        boolean b = sword_4.find(50, matrix);
        System.out.println(b);
    }
}
