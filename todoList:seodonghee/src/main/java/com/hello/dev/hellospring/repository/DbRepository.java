package com.hello.dev.hellospring.repository;

import com.hello.dev.hellospring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DbRepository implements CommonRepository<Todo> {

    @Autowired
    private TodoJpaRepository jpaRepository;

    @Override
    public void add(Todo todo) {
        jpaRepository.save(todo);
    }

    @Override
    public void update(Todo todo) {
        if(jpaRepository.existsById(todo.getId())) {
            jpaRepository.save(todo);
        }
    }

    @Override
    public void delete(Todo todo) {
        jpaRepository.delete(todo);
    }

    @Override
    public List<Todo> listByStatus(String status) {
        return jpaRepository.findByStatus(status);
    }
}
