package com.xunhuan.java.algorithm.leetcode.recursion;

/**
 * 斐波那契数列
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

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        System.out.println(++i);
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * 方法2 效率高
     * @param N
     * @return
     */
    public int fib2(int N) {
        int[] res = new int[N + 2];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < N + 2; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[N];
    }

    public static void main(String[] args) {
        int fib = new LeetCode_509().fib2(30);
        System.out.println(fib);
    }
}
