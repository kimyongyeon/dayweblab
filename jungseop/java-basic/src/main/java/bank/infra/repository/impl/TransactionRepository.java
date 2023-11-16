package main.java.bank.infra.repository.impl;

import main.java.bank.domain.model.Transaction;
import main.java.bank.infra.repository.MemoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository implements MemoryRepository<Long, Transaction> {

    private final Map<Long, Transaction> store = new HashMap<>();

    @Override
    public void add(Transaction transaction) {
        store.put(transaction.getTransactionId(), transaction);
    }

    @Override
    public void update(Long id, Transaction transaction) {
        store.replace(id, transaction);
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    @Override
    public Transaction findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Transaction> findAll() {
        return store.values().stream().toList();
    }
}
