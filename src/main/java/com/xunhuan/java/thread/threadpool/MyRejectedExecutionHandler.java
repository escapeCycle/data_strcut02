package com.xunhuan.java.thread.threadpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author tianh
 * @description:
 * @date 2024/4/13 10:48
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // 对被拒绝的任务进行处理

    }
}
