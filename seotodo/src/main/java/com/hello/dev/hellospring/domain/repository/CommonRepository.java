package com.hello.dev.hellospring.domain.repository;

import java.util.List;

public interface CommonRepository<T> {

    T one(Long id);

    List<T> list();

    void add(T t);

    void update(Long id, T t);

    void delete(Long id);

}
