package com.xunhuan.java.thread.juc;


/**
 * ThreadLocal test
 * 每个 Thread 都有一个 ThreadLocal.ThreadLocalMap 对象。  结构是一个map ，key就是ThreadLocal，value是设置的值
 * 所以不存在多线程竞争
 *
 * 保证每个线程中的变量和其他线程隔离
 *
 * 在一些场景 (尤其是使用线程池) 下，由于 ThreadLocal.ThreadLocalMap 的底层数据结构导致 ThreadLocal 有内存泄漏的情况，
 * 应该尽可能在每次使用 ThreadLocal 后手动调用 remove()，以避免出现 ThreadLocal 经典的内存泄漏甚至是造成自身业务混乱的风险。
 */
public class ThreadLocalExample {


    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();


        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000L);
                threadLocal.set(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /* 不受thread2 影响,仍然为自己线程内的值 1 **/
            System.out.println(threadLocal.get());

            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set(2);
            threadLocal.remove();
        });
        thread1.start();
        thread2.start();

    }

}
