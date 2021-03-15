package com.xunhuan.java.thread.basic;

/**
 * @author tianh
 * @description: 设置Thread.interrupt() 中断标志之后，
 * 果线程处于被阻塞状态(调用sleep\wait\join等),线程立即退出被阻塞状态,并抛出异常(InterruptedException)，中断状态也会被清除
 * @date 2021-03-15 10:11
 */
public class InterruptExample2 {


    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().interrupt();
        Thread.sleep(3000L); // 抛出异常

    }
}
