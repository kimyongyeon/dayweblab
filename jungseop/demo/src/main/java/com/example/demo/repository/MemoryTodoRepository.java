package com.example.demo.repository;

import com.example.demo.model.todo.TodoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryTodoRepository implements TodoRepository<TodoDto> {

    private final List<TodoDto> todoList = new ArrayList<>();

    @Override
    public void add(TodoDto todoDto) {
        todoList.add(todoDto);
    }

    @Override
    public void update(TodoDto todoDto) {
        todoList.stream().filter(p -> p.equals(todoDto)).map(p -> p.equals(todoDto));
    }

    @Override
    public void delete(TodoDto todoDto) {
        todoList.remove(todoDto);
    }

    @Override
    public List<TodoDto> list(TodoDto todoDto) {
        return todoList;
    }
}
