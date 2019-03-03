package com.xunhuan.java.algorithm.leetcode.string;

import java.util.Arrays;

/**
 * @author tianhuan
 * @date 2019-03-03 10:26
 **/
public class LeetCode_977 {

    public int[] sortedSquares1(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares2(int[] A) {
        if (A.length == 1) {
            return new int[]{A[0] * A[0]};
        }

        int[] result = new int[A.length];
        int rightPoint = 0;
        int leftPoint = 0;
        while (rightPoint < A.length && A[rightPoint] < 0) {
            rightPoint++;
        }
        leftPoint = rightPoint - 1;
        int t = 0;
        while (leftPoint >= 0 && rightPoint < A.length) {
            /*
                左边大于右边 把小的那边放到新数组，并且小的那边往外围移动
             */
            if (A[leftPoint] * A[leftPoint] > A[rightPoint] * A[rightPoint]) {
                result[t++] = A[rightPoint] * A[rightPoint];
                rightPoint++;
            } else {
                result[t++] = A[leftPoint] * A[leftPoint];
                leftPoint--;
            }
        }

        /*
            如果都为负的 和 最左一位为最大数
         */
        while (leftPoint >= 0) {
            result[t++] = A[leftPoint] * A[leftPoint];
            leftPoint--;
        }
        /*
            最右一位为最大数 和 都为正的
         */
        while (rightPoint < A.length) {
            result[t++] = A[rightPoint] * A[rightPoint];
            rightPoint++;
        }

        return result;
    }

    public int[] sortedSquares3(int[] A) {
        int i = 0, j = A.length - 1;
        int[] result = new int[A.length];

        for (int m = A.length - 1; m >= 0; m--) {
            if (Math.abs(A[j]) > Math.abs(A[i])) {
                result[m] = A[j] * A[j];
                j--;
            } else {
                result[m] = A[i] * A[i];
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arrs = {-20, -4, -1,0, 0, 3, 10};
        int[] results = new LeetCode_977().sortedSquares3(arrs);
        Arrays.stream(results).forEach(System.out::println);
    }
}
