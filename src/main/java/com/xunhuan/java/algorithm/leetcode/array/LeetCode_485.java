package com.xunhuan.java.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 求一个数组中连续1的最长长度
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * @author tianhuan
 * @date 2019-03-25 18:54
 **/
public class LeetCode_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                max++;
            } else {
                res[count] = max;
                count++;
                max = 0;
            }
            if (i == nums.length - 1 && nums[nums.length - 1] == 1) {
                res[count] = max;
            }
        }
        Arrays.sort(res);
        return res[nums.length - 1];
    }

    /**
     * 精简
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0, count = 0;
        for (int i = 0; i < nums.length; ++i) {
            count = nums[i] == 0 ? 0 : count + 1;
            max = Math.max(max,count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        int maxCount = new LeetCode_485().findMaxConsecutiveOnes2(nums);
        System.out.println(maxCount);
    }
}
