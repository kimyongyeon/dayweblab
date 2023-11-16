package main.java.bank.domain.model;

import java.time.LocalDateTime;

/**
 * 거래 내역 정보
 * 1. 거래 내역 번호
 * 2. 거래 유형(입금, 출금 등)
 * 3. 금액
 * 4. 거래 일자
 * 5. 계좌 번호
 */
public class Transaction {

    private static long seq = 1l;

    private final long transactionId;
    private final Type type;
    private final long amount;
    private final LocalDateTime date;
    private final String accountId;

    public Transaction(Type type, long amount, String accountId) {
        this.transactionId = seq++;
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.accountId = accountId;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public static long getSeq() {
        return seq;
    }

    public Type getType() {
        return type;
    }

    public long getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getAccountId() {
        return accountId;
    }
}
