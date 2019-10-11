package com.xunhuan.java.delayqueue;

import com.xunhuan.java.delayqueue.domain.Message;

import java.util.concurrent.DelayQueue;


/**
 * @author tianh
 * 延迟队列管理器
 */
public class DelayQueueManager {

    private static DelayQueue<Message> delayQueue = null;

    static {
        // 创建延迟队列
        delayQueue = new DelayQueue<>();
    }

    public static DelayQueue<Message> getDelayQueue() {
        return delayQueue;
    }
}
