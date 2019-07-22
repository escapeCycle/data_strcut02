package com.xunhuan.java.thread.util;

import java.util.concurrent.*;

/**
 * 线程池初始化
 */
public class ThreadPoolInstance {

    private static final int coreSize = 10;
    private static final int maxSize = 20;
    /**
     * 单位s
     **/
    private static final long aliveTime = 60L;

    /**
     * FIFO 先进先出阻塞队列（最大Integer.MAX_VALUE），默认是无界队列，指定参数后是有界，
     */
    private static LinkedBlockingQueue queue = new LinkedBlockingQueue(16);

    /**
     * 数组类型有界队列，需指定队列大小，参数fairness公平性，默认为true，遵守FIFO顺序，不接受null元素，容量不可扩展
     */
    private static ArrayBlockingQueue arrQueue = new ArrayBlockingQueue(64);

    /**
     * 特殊的阻塞队列，进和出交替完成，否则不能进入或出队列，没有容纳元素的能力，默认参数为true，表示遵守FIFO顺序
     */
    private static SynchronousQueue syQueue = new SynchronousQueue();

    /**
     * 默认无界队列，可以指定大小，非FIFO规则，按照自然顺序或者构造函数实现的Comparator来排序
     */
    private static PriorityBlockingQueue prQueue = new PriorityBlockingQueue();


    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();

    /**
     * 拒绝策略1:队列满了之后直接丢掉任务，不抛出任何异常
     */
    private static RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
    /**
     * 拒绝策略2:默认值，队列满了之后丢掉任务，并抛出异常
     */
    private static RejectedExecutionHandler handler2 = new ThreadPoolExecutor.AbortPolicy();

    /**
     * 拒绝策略3:队列满了之后丢掉最老的，也就是将队列头部的丢弃掉，然后将最新的加入队列
     */
    private static RejectedExecutionHandler handler3 = new ThreadPoolExecutor.DiscardOldestPolicy();
    /**
     * 拒绝策略4:如果添加到线程池失败，主线程会自己执行该任务，不会等待线程池中的线程执行
     */
    private static RejectedExecutionHandler handler4 = new ThreadPoolExecutor.CallerRunsPolicy();


    public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSize,
            maxSize,
            aliveTime,
            TimeUnit.SECONDS,
            queue,
            threadFactory,
            handler2);
}
