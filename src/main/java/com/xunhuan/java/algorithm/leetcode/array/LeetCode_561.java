package com.xunhuan.java.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * @author tianhuan
 * @date 2019-03-10 19:46
 **/
public class LeetCode_561 {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum = sum + Math.min(nums[i],nums[i+1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2};

        int sum = new LeetCode_561().arrayPairSum(nums);
        System.out.println(sum);

    }
}
