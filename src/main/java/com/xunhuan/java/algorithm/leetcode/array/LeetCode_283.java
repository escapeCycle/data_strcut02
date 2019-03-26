package com.xunhuan.java.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 将数组中的0 全部移到最后，保持非0数字的相对位置不变
 *
 * @author tianhuan
 * @date 2019-03-26 22:23
 **/
public class LeetCode_283 {


    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        if (nums.length == 0 || nums.length == 1) return;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; ++j) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null) return;
        if (nums.length == 0 || nums.length == 1) return;
        int j = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[j] == 0 && nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            } else if (nums[j] != 0) {
                j++;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        if (nums == null) return;
        if (nums.length == 0 || nums.length == 1) return;
        Integer zeroIndex = null;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && zeroIndex != null) {
                nums[zeroIndex++] = nums[i];
                nums[i] = 0;
            } else if (nums[i] == 0 && zeroIndex == null) {
                zeroIndex = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrs = {0, 1, 0, 3, 12};
        new LeetCode_283().moveZeroes2(arrs);
        Arrays.stream(arrs).forEach(System.out::println);
    }
}
