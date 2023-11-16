package main.java.bank.infra.repository.impl;

import main.java.bank.domain.model.Account;
import main.java.bank.infra.repository.MemoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository implements MemoryRepository<String, Account> {

    private final Map<String, Account> store = new HashMap<>();

    @Override
    public void add(Account account) {
        store.put(account.getAccountNumber(), account);
    }

    @Override
    public void update(String id, Account account) {
        store.replace(id, account);
    }

    @Override
    public void delete(String id) {
        store.remove(id);
    }

    @Override
    public Account findById(String id) {
        return store.get(id);
    }

    @Override
    public List<Account> findAll() {
        return store.values().stream().toList();
    }
}
