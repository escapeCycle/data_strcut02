package com.xunhuan.java.algorithm.leetcode.string;

import java.util.Arrays;

/**
 * 分割回文串II
 *
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文。
 * 返回s符合要求的的最少分割次数。
 *
 * Input: "aab"
 * Output: 1
 *
 * @author tianhuan
 * @date 2019-02-28 17:55
 **/
public class LeetCode_132 {

    public int minCut(String s) {
        boolean[][] b = new boolean[s.length()][s.length()];
        for (int i = 1; i <= s.length(); i++) {
            //j表示以i为中心的子字符串左侧
            //s.length() - i + 1,计算的是i的右侧还有几个字符
            //所以j在[0, s.length() - i + 1)
            //这里便能解释为什么i必须从1开始，如果从0开始的话，0是没有左侧的
            for (int j = 0; j < s.length() - i + 1; j++) {
                //以i为中心，与j对应的右侧位置k
                int k = j + i - 1;
                if (i == 1) {
                    b[j][k] = true;
                } else {
                    if (s.charAt(j) == s.charAt(k) && (j == k - 1 || b[j + 1][k - 1]))
                        b[j][k] = true;
                }
            }
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (b[0][i]) {
                dp[i] = 0;
            }
            for (int j = 0; j < i; j++) {
                if (b[j + 1][i])
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        String str = "aacscss";
        int sum = new LeetCode_132().minCut(str);
        System.out.println(sum);
    }
}
