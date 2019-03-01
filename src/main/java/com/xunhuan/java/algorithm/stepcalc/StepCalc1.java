package com.xunhuan.java.algorithm.stepcalc;

/**
 * @author tianhuan
 * @date 2018-11-08 18:43
 **/
public class StepCalc1 {

    public int loop(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + "不能小于1");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int one = 2;
        int two = 1;
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        StepCalc1 stepCalc1 = new StepCalc1();
        System.out.println(stepCalc1.loop(400));
        long end = System.currentTimeMillis();
        System.out.println(end-start + "ms");
    }
}
