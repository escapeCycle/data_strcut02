package com.xunhuan.java.delayqueue.domain;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author tianh
 * 延迟队列消息实体
 */
@Data
public class Message<T> implements Delayed {

    private T body; // 消息体
    private long excuteTime; //执行时间
    private String type; // 消息类型

    /**
     *
     * @param delayTime 延迟时间 单位ms
     * @param type
     */
    public Message(long delayTime, String type) {
        this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        this.type = type;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed delayed) {
        long d = (getDelay(TimeUnit.NANOSECONDS) - delayed.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    public static void main(String[] args) {
        System.out.println(TimeUnit.NANOSECONDS.convert(100, TimeUnit.MILLISECONDS) + System.nanoTime());
    }
}
