package com.xunhuan.java.java8;

import java.util.function.Predicate;

/**
 * @author tianhuan
 * @date 2019-01-20 11:35
 **/
public class PredicateTest {

    public static void main(String[] args) {

        Predicate<String> predicate = p -> p != null && p.length() > 5;
        System.out.println(predicate.test("he"));
    }

}
