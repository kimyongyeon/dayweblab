package main.java.bank.infra.repository.impl;

import main.java.bank.domain.model.Customer;
import main.java.bank.infra.repository.MemoryRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository implements MemoryRepository<Long, Customer> {

    private final Map<Long, Customer> store = new HashMap<>();

    @Override
    public void add(Customer customer) {
        store.put(customer.getCustomerId(), customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        store.replace(id, customer);
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    @Override
    public Customer findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Customer> findAll() {
        return store.values().stream().toList();
    }
}
