package com.xunhuan.java.algorithm.sword_offer;

import java.util.Arrays;

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 */
public class Sword_10_4 {

    /**
     * 跳上 n-1 级台阶，可以从 n-2 级跳 1 级上去，也可以从 n-3 级跳 2 级上去...，那么
     * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     * f(n) = f(n-1) + f(n-2) + ... + f(0)
     * f(n) - f(n-1) = f(n-1)
     * f(n) = 2*f(n-1)
     * <p>
     * 也就是 2的n-1次方
     *
     * @param target
     * @return
     */
    public int jumpFloorII_StyleI(int target) {
        return (int) Math.pow(2, target - 1);
    }

    public int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++)
            for (int j = 0; j < i; j++)
                dp[i] += dp[j];
        return dp[target - 1];
    }

    public static void main(String[] args) {
        Sword_10_4 sword_10_4 = new Sword_10_4();
        int cnt = sword_10_4.jumpFloorII(3);
        System.out.println(cnt);
    }
}
