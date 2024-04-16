package com.xunhuan.java.algorithm.左神.array;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author tianh
 * @description: 给定一个非负数组arr 和一个正数m。
 * 返回arr的所有子序列中累加和%m之后的最大值
 * (1) 如果arr中每个数字不大，怎么做这道题  (背包问题--动态规划)
 * (2) 如果arr中m的值很小，怎么做这道题
 * (3) 如果arr的长度很短，但是arr每个数字比较大且m比较大呢
 * <p>
 * 暴力解法 -- 将所有排列分解成一个二叉树，树高即为数组length n ，所有组合即为2的n次幂
 * @date 2022/8/3 16:39
 */
public class Code_05 {


    /**
     * O(2的n次幂)
     *
     * @param arr
     * @param m
     * @return
     */
    public static int max1(int[] arr, int m) {
        HashSet<Integer> set = new HashSet<>();
        process(arr, 0, 0, set);
        int max = 0;
        for (Integer sum : set) {
            max = Math.max(max, sum % m);
        }
        return max;
    }

    public static void process(int[] arr, int index, int sum, HashSet<Integer> set) {
        if (index == arr.length) {
            set.add(sum);
        } else {
            process(arr, index + 1, sum, set);
            process(arr, index + 1, sum + arr[index], set);
        }
    }

    /**
     * 动态规划方式 ，适合每个数字比较小的
     * 时间复杂度 O(N * sum)
     *
     * @param arr
     * @param m
     * @return
     */
    public static int max2(int[] arr, int m) {
        // 计算数组所有元素之和
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int N = arr.length;
        // 构建二维布尔类型数组
        boolean[][] dp = new boolean[N][sum + 1];
        // 所有的第一列都是true
        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }
        // 将第一行与arr[0]相等时的位置置为true
        dp[0][arr[0]] = true;
        // 第0行和第0列都不用管,已经设置了
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - arr[i] >= 0) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - arr[i]];
                }
            }
        }
        int res = 0;
        for (int j = 0; j <= sum; j++) {
            if (dp[N - 1][j]) {
                res = Math.max(res, j % m);
            }
        }
        return res;
    }

    /**
     * 动态规划方式 ，适合m比较小的
     *
     * @param arr
     * @param m
     * @return
     */
    public static int max3(int[] arr, int m) {

        int N = arr.length;
        boolean[][] dp = new boolean[N][m];
        // 所有的第一列都是true
        for (int i = 0; i < N; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[1] % m] = true;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j];
                int cur = arr[i] % m;
                if (j - cur >= 0) {
                    dp[i][j] = dp[i][j] | dp[i - 1][j - cur];
                }
                if (j - cur < 0) {
                    dp[i][j] = dp[i][j] | dp[i - 1][m + j - cur];
                }
            }
        }
        int res = 0;
        // 返回最后一位即为最大值
        for (int i = 0; i < m; i++) {
            if (dp[N - 1][i]) {
                res = i;
            }
        }
        return res;
    }

    /**
     * 如果arr累加和很大，m也很大，但是arr长度相对不大
     *
     * @param arr
     * @param m
     * @return
     */
    public static int max4(int[] arr, int m) {
        if (arr.length == 1) {
            return arr[0] % m;
        }
        // 分为两部分, 降低规模
        int mid = (arr.length - 1) / 2;
        TreeSet<Integer> sortSet1 = new TreeSet<>();
        process4(arr, 0, 0, mid, m, sortSet1);
        TreeSet<Integer> sortSet2 = new TreeSet<>();
        process4(arr, mid + 1, 0, arr.length - 1, m, sortSet2);
        int res = 0;
        for (Integer left : sortSet1) {
            // <= m-1-left 最近的值  logN级别的复杂度
            res = Math.max(res, left + sortSet2.floor(m - 1 - left));
        }
        return res;
    }

    public static void process4(int[] arr, int index, int sum, int end, int m, TreeSet sortSet) {
        if (index == end + 1) {
            sortSet.add(sum % m);
        } else {
            // 两个分支，一种是累加、一种是不累加
            process4(arr, index + 1, sum, end, m, sortSet);
            process4(arr, index + 1, sum + arr[index], end, m, sortSet);
        }
    }
}
