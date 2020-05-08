package com.xunhuan.java.algorithm.geekbang.design_model.day_29;

import com.xunhuan.java.algorithm.geekbang.design_model.day_29.enums.STATUS;
import org.junit.Assert;

import javax.transaction.InvalidTransactionException;

/**
 * @author tianh
 * @description:
 * @date 2020-05-07 10:54
 */
public class TestTransaction {

    public void testExecute() throws InvalidTransactionException {
        Long buyerId = 123L;
        Long sellerId = 234L;
        Long productId = 345L;
        Long orderId = 456L;
        Transaction transaction = new Transaction(null, buyerId, sellerId, productId, orderId) {
            @Override
            protected boolean isExpired() {
                return true;
            }
        };
        TransactionLock mockLock = new TransactionLock() {
            @Override
            public boolean lock(String id) {
                return true;
            }

            @Override
            public void unlock(String id) {
            }
        };
        transaction.setWalletRpcService(new MockWalletRpcServiceOne());
        transaction.setTransactionLock(mockLock);
        transaction.setCreateTimestamp(System.currentTimeMillis() - 14);
        boolean executedResult = transaction.execute();
        Assert.assertTrue(executedResult);
        Assert.assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }
}
