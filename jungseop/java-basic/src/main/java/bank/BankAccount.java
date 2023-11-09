package main.java.bank;

public class BankAccount {

    private final String ownerName;
    private final String accountNumber;
    private double balance;

    public BankAccount(String ownerName, String accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //입금
    public void deposit(double amount) {
        balance += amount;
    }

    //출금
    public void withdraw(double amount) {
        if (balance < amount) {
            throw new NotEnoughBalance(ownerName + " : 잔액이 부족합니다. balance = " + balance + ", amount = " + amount);
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void getAccountInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Owner: " + ownerName +
                ", Account Number: " + accountNumber +
                ", Balance: $" + balance;
    }
}
