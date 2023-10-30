package com.hello.dev.hellospring.domain.service;

import com.hello.dev.hellospring.domain.dto.TodoDTO;
import com.hello.dev.hellospring.domain.repository.MemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final MemRepository repository;

    public void todoAdd(TodoDTO todoDTO) {
        try {
            TodoDTO one = repository.one(todoDTO.getId());
            if (one != null) {
                repository.update(one.getId(), todoDTO);
            }
            repository.add(todoDTO);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    public TodoDTO findById(Long id) {
        return repository.one(id);
    }

    public List<TodoDTO> list() {
        return repository.list();
    }


    public void todoUpdate(Long id, TodoDTO todoDTO) {
        repository.update(id, todoDTO);
    }

    public void todoPatch(Long id, String state) {
        TodoDTO one = repository.one(id);
        one.setState(state);
        repository.add(one);
    }


}
