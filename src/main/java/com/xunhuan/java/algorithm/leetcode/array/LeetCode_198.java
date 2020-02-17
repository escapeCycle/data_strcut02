package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 动态规划
 * 求一个数组内不能连续位置相加的和的最大值
 *
 * @author tianhuan
 * @date 2019-03-06 11:48
 **/
public class LeetCode_198 {


    /**
     * 动态规划解法，每个index的位置有两种选择，
     * rob或者notrob，rob的话可以更新值，
     * notrob可以一直把前面的最大值向后传递，
     * 最后返回rob和notrob的最大值即可。
     * 时间复杂度为O(n)，空间复杂度为O(1)。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int rob = 0, notrob = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = rob;
            rob = notrob + nums[i];
            notrob = Math.max(temp, notrob);
        }
        return Math.max(rob, notrob);
    }

    /**
     * 从前到后
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        res[2] = Math.max(nums[2] + res[0], res[1]);
        for (int i = 3; i < nums.length; i++) {
            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
        }
        return res[res.length - 1];
    }

    /**
     * 从后到前
     *
     * @param nums
     * @return
     */
    public int rob3(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] res = new int[n];
        /**
         * 先将最后三个处理
         */
        res[n - 1] = nums[n - 1];
        res[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
        res[n - 3] = Math.max(nums[n - 3] + res[n - 1], res[n - 2]);

        for (int i = n - 4; i >= 0; i--) {
            res[i] = Math.max(nums[i] + res[i + 2], res[i + 1]);
        }

        return res[0];
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{2, 7, 9, 3, 1};
//        int[] arrs = new int[]{2, 1, 1, 2};

        int robs = new LeetCode_198().rob(arrs);
        System.out.println(robs);
    }
}
