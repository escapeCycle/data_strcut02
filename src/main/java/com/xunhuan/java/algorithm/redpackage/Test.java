package com.xunhuan.java.algorithm.redpackage;

/**
 * @Auther: tianhuan
 * @Date: 2019/5/29 14:00
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        double money = 20;
        int people = 10;

        for (int i = 0; i < 10; ++i) {
            double res = money / people * 2;
            System.out.println(res);
            people--;
            money = money - res;
        }
    }
}
