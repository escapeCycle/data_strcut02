package com.xunhuan.java.algorithm.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列（矩形覆盖和跳台阶都属于此类问题）
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * <p>
 * <p>
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * @author tianhuan
 * @date 2019-03-10 21:50
 **/
public class LeetCode_509 {

    public static int i = 0;

    /**
     * 递归,存在重复计算,如f(4) = f(3) + f(2),f(3) = f(2) + f(1), f(2)被计算两次
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        Map<Integer, Integer> map = new HashMap<>(10);
        if (map.containsKey(N)) {
            return map.get(N);
        }
        System.out.println(++i);
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 方法2 效率高,不重复计算  空间复杂度O(n)
     *
     * @param N
     * @return
     */
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        int[] res = new int[N + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= N; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[N];
    }

    /**
     * 方法3 效率高,不重复计算  空间复杂度O(1)
     * @param N
     * @return
     */
    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for (int i = 2; i <= N; i++) {
            fib = pre2 + pre1;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    public static void main(String[] args) {
        int fib = new LeetCode_509().fib3(30);
        System.out.println(fib);
    }
}
