package com.xunhuan.java.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 按奇偶排序数组
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 *
 * @author tianhuan
 * @date 2019-03-09 17:37
 **/
public class LeetCode_905 {

    public int[] sortArrayByParity(int[] A) {
        if (A == null) return null;
        if (A.length == 0) return null;
        if (A.length == 1) return A;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0 && i != 0) {
                for (int j = i - 1; j >= 0; j--) {
                    if (A[j] % 2 != 0) {
                        int temp = A[j];
                        A[j] = A[j + 1];
                        A[j + 1] = temp;
                    }
                }
            }
        }
        return A;
    }


    public int[] sortArrayByParity2(int[] A) {
        if (A == null) return null;
        if (A.length == 0) return null;
        if (A.length == 1) return A;

        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j > 0; j--) {
                /*
                    如果是前面奇数，后面偶数，则交换
                 */
                if (A[j - 1] % 2 != 0 && A[j] % 2 == 0) {
                    int temp = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = temp;
                }
            }
        }
        return A;
    }

    public int[] sortArrayByParity3(int[] A) {
        int[] arrs = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                arrs[t++] = A[i];
            }

        }
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 1) {
                arrs[t++] = A[i];
            }

        }
        return arrs;
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{2, 3, 5, 8, 9, 1, 4};
        int[] ints = new LeetCode_905().sortArrayByParity3(arrs);

        Arrays.stream(ints).forEach(System.out::println);
    }
}
