package com.xunhuan.java.algorithm.search.primesearch;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 查询1-100000之间的素数个数 , 四个线程进行
 *
 * @author tianhuan
 * @date 2019-03-04 13:42
 **/
public class PrimeNumberSearch {
    public static final int COUNT = 100000;
    public static final int THREAD_COUNT = 4;
    public static AtomicInteger integer = new AtomicInteger(0);


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
        Future<Long> f1 = threadPool.submit(new Prime(2, COUNT / THREAD_COUNT));
        Future<Long> f2 = threadPool.submit(new Prime(COUNT / THREAD_COUNT + 1, (COUNT / THREAD_COUNT) * 2));
        Future<Long> f3 = threadPool.submit(new Prime((COUNT / THREAD_COUNT) * 2 + 1, (COUNT / THREAD_COUNT) * 3));
        Future<Long> f4 = threadPool.submit(new Prime((COUNT / THREAD_COUNT) * 3 + 1, COUNT));

        int i = f1.get().intValue() + f2.get().intValue() + f3.get().intValue() + f4.get().intValue();
        System.out.println("1线程"+f1.get().intValue());
        System.out.println("2线程"+f2.get().intValue());
        System.out.println("3线程"+f3.get().intValue());
        System.out.println("4线程"+f4.get().intValue());
        System.out.println(i);
        System.out.println(integer.get());
//        threadPool.awaitTermination(Long.MAX_VALUE,TimeUnit.SECONDS);
        threadPool.shutdown();
//        System.out.println(100000/4);
    }
}


class Prime implements Callable<Long> {
    private int start;
    private int end;
    private int sum = 0; // 同一个实例只会拥有同一个变量，如果多个实例，则拥有多个
//    private static int sum = 0; //由于是静态的，多个实例也只会拥有同一个变量
    private AtomicInteger atomicInteger2 = new AtomicInteger(); // 非单例，此变量每次都初始化不同的


//    public final static ReentrantLock lock = new ReentrantLock();

    public Prime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean isPrimeNum(int num) {

        for (int j = 2; j <= num; j++) {
            if (num % j == 0 && num != j) {
                return false;
            } else {
                continue;
            }
        }

        return true;
    }

    @Override
    public Long call() throws Exception {
//        AtomicInteger atomicInteger = new AtomicInteger();
        int tempSum = 0;
        for (int i = start; i <= end; i++) {

            if (isPrimeNum(i)) {
                System.out.println(Thread.currentThread() + "输出一个素数:" + i);
                PrimeNumberSearch.integer.getAndIncrement();
                sum++;
                atomicInteger2.incrementAndGet();
                tempSum++;
            }
        }


        return (long)atomicInteger2.get();
    }
}