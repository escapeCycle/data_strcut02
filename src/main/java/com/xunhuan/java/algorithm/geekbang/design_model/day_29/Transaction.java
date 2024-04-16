package com.xunhuan.java.algorithm.geekbang.design_model.day_29;

import com.google.common.annotations.VisibleForTesting;
import com.xunhuan.java.algorithm.geekbang.design_model.day_29.enums.STATUS;
import lombok.Data;
import java.io.InvalidClassException;

@Data
public class Transaction {
    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private Long orderId;
    private Long createTimestamp;
    private Double amount;
    private STATUS status;
    private String walletTransactionId;


    private WalletRpcService walletRpcService;
    private TransactionLock lock;

    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }

    public void setTransactionLock(TransactionLock transactionLock) {
        this.lock = transactionLock;
    }

    public Transaction(String preAssignedId, Long buyerId, Long sellerId, Long productId, Long orderId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
//            this.id = IdGenerator.generateTransactionId();
            this.id = "lalala";
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis();
    }

    @VisibleForTesting
    protected boolean isExpired() {
        long executionInvokedTimestamp = System.currentTimeMillis();
        return executionInvokedTimestamp - createTimestamp > 14;
    }

    public boolean execute() throws InvalidClassException {
        if ((buyerId == null || (sellerId == null || amount < 0.0))) {
            throw new InvalidClassException("");
        }
        if (status == STATUS.EXECUTED) return true;
        boolean isLocked = false;
        try {
            isLocked = lock.lock(id);
            if (!isLocked) {
                return false; // 锁定未成功，返回false，job兜底执行
            }
            if (status == STATUS.EXECUTED) return true; // double check
            if (isExpired()) {
                this.status = STATUS.EXPIRED;
                return false;
            }
            WalletRpcService walletRpcService = new WalletRpcService();
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                lock.unlock(id);
            }
        }
    }
}