package com.example.demo.repository;

import java.util.List;

public interface TodoRepository<T> {

    void add(T t);

    void update(T t);

    void delete(T t);

    List<T> list(T t);

}
