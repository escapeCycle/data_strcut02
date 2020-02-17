package com.xunhuan.java.algorithm.geekbang.design_model.day_34;

public class Test {

    public static void main(String[] args) {

        String str = "http://198.0.0.1";

        String[] split = str.split("\\.");
        System.out.println(split[split.length-1]);


        char a = 'A' + 2;

        System.out.println(a);

        String id = String.format("%s-%d-%s", "255", System.currentTimeMillis(), "1A2B3C4D");
        System.out.println(System.currentTimeMillis());
        System.out.println(id);

        int z = 'z';
        System.out.println(z);
    }
}
