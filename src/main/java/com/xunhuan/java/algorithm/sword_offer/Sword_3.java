package com.xunhuan.java.algorithm.sword_offer;

import com.xunhuan.java.algorithm.util.CommonUtil;

/**
 * 剑指offer 第三题
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * Output:
 * 2
 *
 * 1 3 2 0 1 5
 * 3 1 2 0 1 5
 * 0 1 2 3 1 5
 * 此时 nums[i] = nums[nums[i]]
 *
 *
 *
 * @author tianhuan
 * @date 2019-04-19 12:13
 **/
public class Sword_3 {

    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) return false;
        for (int i = 0; i < length; i++) {
            // 保证数组中数字在 0(包含) -- length-1(不包含) 之间
            if (nums[i] >= length || nums[i] < 0) {
                return false;
            }
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                CommonUtil.swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 1, 0, 4, 5};
        Sword_3 swordN = new Sword_3();
        int[] res = new int[1];
        boolean duplicate = swordN.duplicate(nums, nums.length, res);

        System.out.println(duplicate);
        System.out.println(res[0]);
    }

}
