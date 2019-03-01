package com.xunhuan.java.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author tianhuan
 * @date 2019-01-16 18:00
 **/
public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);

        list.forEach(x -> System.out.println(x));
        list.forEach(System.out::println);
    }
}
