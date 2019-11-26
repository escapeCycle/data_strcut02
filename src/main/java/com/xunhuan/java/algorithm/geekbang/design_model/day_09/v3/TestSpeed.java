package com.xunhuan.java.algorithm.geekbang.design_model.day_09.v3;

/**
 * 反射和直接实例化 速度测试
 */
public class TestSpeed {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        int NUM = 1000000;
        _Stopwatch stopwatch = new _Stopwatch();
        for (int i = 0; i < NUM; i++) {
            ImageStore imageStore = new ImageStore();
        }

        System.out.println(stopwatch.elapsedTime() + " s");
        for (int i = 0; i < NUM; i++) {
            ImageStore imageStore = (ImageStore) Class.forName("com.xunhuan.java.algorithm.geekbang.design_model.day_09.v3.ImageStore").newInstance();
        }
        System.out.println(stopwatch.elapsedTime() + " s");

//        0.006 s
//        0.942 s

    }
}
