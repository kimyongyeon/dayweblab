package com.example.demo.controller;

import com.example.demo.model.todo.TodoDto;
import com.example.demo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @GetMapping("/todos")
    public List<TodoDto> list() {
        return service.list(TodoDto.builder().build());
    }

    @PostMapping("/todo")
    public String todoAdd(@RequestBody TodoDto todoDTO) {
        service.todoAdd(todoDTO);
        return "redirect:/todos";
    }

    @PutMapping("/todo")
    public String todoUpdate(@RequestBody TodoDto todoDTO) {
        service.todoUpdate(todoDTO);
        return "redirect:/todos";
    }

    @DeleteMapping("/todo")
    public String todoDelete(@RequestBody TodoDto todoDTO) {
        service.todoDelete(todoDTO);
        return "redirect:/todos";
    }
}
