package main.java.bank.domain.model;

/**
 * 계좌 정보
 * 1. 계좌번호
 * 2. 잔고
 * 3. 예금주 ID
 */
public class Account {

    private final String accountNumber; //계좌번호
    private final long balance; //잔고
    private final long owner; //예금주 ID

    public Account(String accountNumber, long balance, long owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public long getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "계좌 번호 = " + accountNumber +
                ", 잔고 = " + balance +
                ", 예금주 = " + owner;
    }
}
