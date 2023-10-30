package com.hello.dev.hellospring.repository;

import com.hello.dev.hellospring.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoJpaRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByStatus(String status);
}
