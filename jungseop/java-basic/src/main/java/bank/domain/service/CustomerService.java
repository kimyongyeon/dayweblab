package main.java.bank.domain.service;

import main.java.bank.domain.model.Account;
import main.java.bank.domain.model.Customer;
import main.java.bank.infra.repository.MemoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    private final MemoryRepository<Long, Customer> customerRepository;
    private final MemoryRepository<String, Account> accountRepository;

    public CustomerService(
            MemoryRepository<Long, Customer> customerRepository,
            MemoryRepository<String, Account> accountRepository
    ) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public void openAccount(Account account) {
        accountRepository.add(account);
    }

    public void closeAccount(Account account) {
        accountRepository.delete(account.getAccountNumber());
    }

    public List<String> getAccountDetails(long customerId) {
        List<Account> accounts = accountRepository.findAll();
        List<Account> collect = accounts.stream()
                .filter(account -> account.getOwner() == customerId)
                .collect(Collectors.toList());

        return collect.stream()
                .map(Account::toString)
                .collect(Collectors.toList());
    }

}
