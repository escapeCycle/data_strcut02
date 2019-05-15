package com.xunhuan.java.lock;

/**
 * @author tianhuan
 * @date 2019-03-21 17:00
 **/
public class SynchronizedTest2 {

    public static void main(String[] args) {
        synchronized (SynchronizedTest2.class){

        }
        method();
    }

    public static void method(){
        synchronized(SynchronizedTest2.class){
        }
    }
}
