package com.xunhuan.java.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 找出数组中能组成三角形的 最大三个数之和（即三角形周长），没有能组成三角形的返回0
 * Example 3:
 * <p>
 * Input: [3,2,3,4]
 * Output: 10
 *
 * @author tianhuan
 * @date 2019-03-22 14:04
 **/
public class LeetCode_976 {


    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return A[i] + A[i + 1] + A[i + 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {

//        int[] A = {3, 2, 3, 4};
//        int sum = new LeetCode_976().largestPerimeter(A);
//        System.out.println(sum);

    }
}
