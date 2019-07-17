package com.xunhuan.java.algorithm.leetcode.array;


/**
 * Duplicate Zeros
 *
 * 数组长度固定，将是0 的元素后面的一位增加一个0，其余元素后移，舍掉超出长度的元素
 *
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 */
public class LeetCode_1089 {

    public void duplicateZeros(int[] arr) {
        if (arr == null) return;
        if (arr.length == 0) return;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j >= i; j--) {
                    if (i == j) {
                        i++;
                        break;
                    }
                    arr[j] = arr[j - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        LeetCode_1089 leetCode_1089 = new LeetCode_1089();
        leetCode_1089.duplicateZeros(arr);
    }
}
