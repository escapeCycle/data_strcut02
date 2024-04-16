package com.xunhuan.java.thread.problem.fifth;

import java.io.IOException;

/**
 * @author tianh
 * @description: this 逸出问题， 在构造方法中使用线程(乱序)
 * @date 2022/6/28 16:55
 */
public class T03_ThisEscape {

    private int num = 0;

    public T03_ThisEscape() {
        new Thread(() -> System.out.println(num)).start();
    }

    public static void main(String[] args) throws IOException {
        new T03_ThisEscape();
        System.in.read();
    }
}
