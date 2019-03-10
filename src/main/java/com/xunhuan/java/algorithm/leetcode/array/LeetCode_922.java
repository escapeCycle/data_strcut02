package com.xunhuan.java.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author tianhuan
 * @date 2019-03-10 20:47
 **/
public class LeetCode_922 {

    public int[] sortArrayByParityII(int[] A) {

        for (int i = 0; i < A.length; i++) {
            /*
                位置奇数 值偶数
             */
            if ((A[i] & 1) == 0 && (i & 1) != 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if ((A[j] & 1) != 0 && (j & 1) == 0) {
                        swap(i, j, A);
                    }
                }
            }

            /*
                位置偶数 值奇数
             */
            if ((A[i] & 1) != 0 && (i & 1) == 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if ((A[j] & 1) == 0 && (j & 1) != 0) {
                        swap(i, j, A);
                    }
                }
            }
        }
        return A;
    }

    public void swap(int i, int j, int[] arrs) {
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }


    /**
     * 方法2 遍历少
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {
        for (int i = 0, j = 1; i < A.length; i += 2) {
            /*
                find next odd-index item A[j] with even value.
             */
            while (j < A.length && A[j] % 2 == 1) {
                j += 2;
            }
            /*
                if odd-index item A[i] is odd, swap it with A[j].
             */
            if (A[i] % 2 == 1) {
                swap(i, j, A);
                j += 2;
            }
        }
        return A;
    }

    /**
     * 方法3
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII3(int[] A) {
        int i = 0, j = 1, n = A.length;
        while (i < n && j < n) {

            while (i < n && (A[i] & 1) == 0) {
                i += 2;
            }
            while (j < n && (A[j] & 1) != 0) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(i, j, A);
            }

        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 2, 5, 7};
        int[] ints = new LeetCode_922().sortArrayByParityII2(A);
        Arrays.stream(A).forEach(System.out::println);
    }
}
