package com.xunhuan.java.algorithm.util;

/**
 * @author tianhuan
 * @date 2019-04-19 12:18
 **/
public class CommonUtil {

    /**
     * 数组中交i、j交换位置
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void swapStr(String[] nums, int i, int j) {
        if (i == j) return;
        String t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
