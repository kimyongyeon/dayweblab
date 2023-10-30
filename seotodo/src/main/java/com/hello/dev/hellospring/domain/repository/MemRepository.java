package com.hello.dev.hellospring.domain.repository;

import com.hello.dev.hellospring.domain.dto.TodoDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemRepository implements CommonRepository<TodoDTO> {

    List<TodoDTO> list = new ArrayList<>();


    @Override
    public TodoDTO one(Long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<TodoDTO> list() {
        return this.list;
    }

    @Override
    public void add(TodoDTO todoDTO) {
        list.add(todoDTO);
    }

    @Override
    public void update(Long id, TodoDTO todoDTO) {
        list.stream().filter(p -> p.getId().equals(id)).map(p -> p.equals(todoDTO));
    }

    @Override
    public void delete(Long id) {
        list.stream().filter(p -> p.getId().equals(id)).map(p -> list.remove(p));
    }
}
