package com.xunhuan.java.algorithm.leetcode.array;

/**
 * 最长递增子序列
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Your algorithm should run in O(n2) complexity.
 *
 * @Auther: tianhuan
 * @Date: 2019/5/10 16:21
 * @Description:
 */
public class LeetCode_300 {


    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 0) return 0;
        int maxNum = 1;
        int[] dp = new int[nums.length];

        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {

            int maxL = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxL = Math.max(maxL, dp[j]);
                }
            }
            dp[i] = maxL + 1;
            maxNum = Math.max(maxNum, dp[i]);
        }
        return maxNum;
    }

    public static void main(String[] args) {
//        int[] arrs = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] arrs = new int[]{10, 9, 2, 5, 3, 4};
        LeetCode_300 leetcode300 = new LeetCode_300();
        int count = leetcode300.lengthOfLIS(arrs);
        System.out.println(count);
    }
}
