package com.xunhuan.java.algorithm.leetcode.array;

/**
 * @author tianhuan
 * @date 2019-03-20 10:06
 **/
public class LeetCode_766 {

    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if ((i + 1) < matrix.length && (j + 1) < matrix[i].length && matrix[i + 1][j + 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arrs = new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };

        boolean flag = new LeetCode_766().isToeplitzMatrix(arrs);
        System.out.println(flag);
    }
}
