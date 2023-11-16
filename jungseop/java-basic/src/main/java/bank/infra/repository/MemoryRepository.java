package main.java.bank.infra.repository;

import java.util.List;

public interface MemoryRepository<K, T> {

    void add(T t);

    void update(K k, T t);

    void delete(K k);

    T findById(K k);

    List<T> findAll();

}
