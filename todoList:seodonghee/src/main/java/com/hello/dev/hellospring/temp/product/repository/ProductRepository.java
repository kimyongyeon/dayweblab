package com.hello.dev.hellospring.temp.product.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    List list();
    void add();
    void update();
    void delete();
}
