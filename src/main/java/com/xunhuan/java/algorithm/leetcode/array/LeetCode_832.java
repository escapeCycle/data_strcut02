package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 翻转图像
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * <p>
 * 先水平翻转，再翻转图片
 * 第一次翻转，即每个数组里面逆序
 * 第二次翻转，即整个数组中所有的1变成0,0变成1
 *
 * @author tianhuan
 * @date 2019-03-09 18:10
 **/
public class LeetCode_832 {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) return null;
        if (A.length == 0) return A;
        int[][] B = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            int m = 0;
            for (int j = A[i].length - 1; j >= 0; j--) {
                if (A[i][j] == 1) {
                    B[i][m++] = 0;
                } else {
                    B[i][m++] = 1;
                }
            }

        }
        return B;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] ints = new LeetCode_832().flipAndInvertImage(A);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j]+" ");
            }
            System.out.println();
        }

    }
}
