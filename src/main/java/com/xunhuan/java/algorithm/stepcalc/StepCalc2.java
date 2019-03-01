package com.xunhuan.java.algorithm.stepcalc;

/**
 * @author tianhuan
 * @date 2018-11-08 18:54
 **/
public class StepCalc2 {


    public int f(int n){
        if (n < 1) {
            throw new IllegalArgumentException(n + "不能小于1");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return f(n-2)+f(n-1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        StepCalc2 stepCalc2 = new StepCalc2();
        System.out.println(stepCalc2.f(40));
        long end = System.currentTimeMillis();
        System.out.println(end-start + "ms");
    }
}
