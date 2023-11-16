package main.java.bank.domain.service;

import main.java.bank.domain.model.Account;
import main.java.bank.domain.model.Transaction;
import main.java.bank.domain.model.Type;
import main.java.bank.infra.repository.MemoryRepository;

public class AccountService {

    private final MemoryRepository<String, Account> accountRepository;
    private final MemoryRepository<Long, Transaction> transactionRepository;

    public AccountService(MemoryRepository<String, Account> accountRepository, MemoryRepository<Long, Transaction> transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public void deposit(String accountId, long amount) {
        Account foundAccount = accountRepository.findById(accountId);

        Account newAccount = new Account(
                foundAccount.getAccountNumber(),
                foundAccount.getBalance() + amount,
                foundAccount.getOwner());
        accountRepository.update(accountId, newAccount);
        transactionRepository.add(new Transaction(Type.DEPOSIT, amount, accountId));
    }

    public void withdraw(String accountId, long amount) {
        Account foundAccount = accountRepository.findById(accountId);

        if (foundAccount.getBalance() < amount) {
             throw new IllegalArgumentException("잔액이 부족합니다.");
        }

        Account newAccount = new Account(
                foundAccount.getAccountNumber(),
                foundAccount.getBalance() - amount,
                foundAccount.getOwner());
        accountRepository.update(accountId, newAccount);
        transactionRepository.add(new Transaction(Type.WITHDRAWAL, amount, accountId));
    }
}
