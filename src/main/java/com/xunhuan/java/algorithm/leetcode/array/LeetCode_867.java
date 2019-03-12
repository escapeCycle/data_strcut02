package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 二维数组，列与行交换
 *
 * Example 1:
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 * @author tianhuan
 * @date 2019-03-12 13:45
 **/
public class LeetCode_867 {


    public int[][] transpose(int[][] A) {
        if(A == null) return null;
        if(A.length == 0) return null;
        int[][] res = new int[A[0].length][A.length];

        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<A[i].length;j++){
                res[j][i] = A[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] transpose = new LeetCode_867().transpose(A);
        for(int i = 0;i<transpose.length;i++) {
            for (int j = 0; j < transpose[i].length; j++) {
                System.out.print(transpose[i][j] +" ");
            }
            System.out.println("");
        }
    }

}
