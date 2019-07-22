package com.xunhuan.java.thread.aqs;

import java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * AQS 使用实例 独享的
 */
public class MyMutex implements Serializable {

    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 是否处于占用状态
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 当状态为0时获取锁，cas成功后更新状态为1
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {

                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 释放锁，将状态更新为0
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }


    private final Sync sync = new Sync();

    /**
     * 加锁操作,代理到重写的  tryAcquire 方法
     */
    public void lock(){
        sync.acquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    /**
     * 释放锁操作, 代理到重写的  tryRelease 方法
     */
    public void unlock(){
        sync.release(1);
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }

}
