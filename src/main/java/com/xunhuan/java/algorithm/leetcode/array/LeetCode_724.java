package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 寻找中心索引  [1, 7, 3, 6, 5, 6]   其中1+7+3 = 5+6  ; 6为中心索引
 *
 * @author tianhuan
 * @date 2019-02-26 0:23
 **/
public class LeetCode_724 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 7, 3, 7, 5, 6};

        System.out.println(pivoIndex2(a));
    }

    public static int pivoIndex(int[] nums) {

        if (nums.length <= 1) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        int startSum = nums[start];
        int endSum = nums[end];

        while (start < end) {
            if (startSum > endSum) {
                end--;
                endSum += nums[end];
                continue;
            }
            if (startSum < endSum) {
                start++;
                startSum += nums[start];
                continue;
            }

            if (startSum == endSum && end - start == 2) {
                return start + 1;
            }
        }
        return -1;
    }


    public static int pivoIndex2(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int leftSum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < nums.length; leftSum += nums[i++]) {

            if (leftSum * 2 == sum - nums[i]) {
                return i;
            }
        }

        return -1;
    }

}
