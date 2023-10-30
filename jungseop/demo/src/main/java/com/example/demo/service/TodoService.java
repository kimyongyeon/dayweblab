package com.example.demo.service;

import com.example.demo.model.todo.TodoDto;
import com.example.demo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    @Qualifier("memoryTodoRepository")
    private final TodoRepository<TodoDto> repository;

    public void todoAdd(TodoDto todoDto) {
        repository.add(todoDto);
    }

    public void todoUpdate(TodoDto todoDto) {
        repository.update(todoDto);
    }

    public void todoDelete(TodoDto todoDto) {
        repository.delete(todoDto);
    }

    public List<TodoDto> list(TodoDto todoDto) {
        return repository.list(todoDto);
    }
}
