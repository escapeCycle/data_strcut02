package com.xunhuan.java;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tianhuan
 * @date 2018-09-28 11:57
 **/
public class App {

    public static void main(String[] args) {
        Integer integer = Integer.valueOf(123);
        Integer integer2 = Integer.valueOf(123);

        Integer integer3 = new Integer(13);
        Integer integer4 = new Integer(13);
        System.out.println(integer == integer2);
        System.out.println(integer3 == integer4);

        String a = "abc";

        a.intern();

        System.out.println(3/2);

        BigDecimal bigDecimal = new BigDecimal(-112335.92);
        BigDecimal abs = bigDecimal.abs(new MathContext(12, RoundingMode.HALF_UP)).setScale(2,RoundingMode.HALF_UP);
        System.out.println(abs);
        ExecutorService executorService = Executors.newFixedThreadPool(10);


    }
}
