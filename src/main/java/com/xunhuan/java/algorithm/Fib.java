package com.xunhuan.java.algorithm;

/**
 * @author tianh
 * @description:
 * @date 2021/9/17 1:26 上午
 */
public class Fib {
    public int fib(int a, int b, int n) {
        if (n == 0)
            return a;
        else
            return fib(a + b, a, n - 1);
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        int a = fib.fib(1, 0, 10);
        System.out.println(a);
    }
}
