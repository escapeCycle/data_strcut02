package com.xunhuan.java.algorithm.geekbang.design_model.day_29;

public class TransactionLock {
    public boolean lock(String id) {
//        return RedisDistributedLock.getSingletonIntance().lockTransction(id);
        return true;
    }

    public void unlock(String id) {
//        RedisDistributedLock.getSingletonIntance().unlockTransction(id);
    }
}