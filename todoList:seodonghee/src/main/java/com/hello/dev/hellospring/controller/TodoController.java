package com.hello.dev.hellospring.controller;

import com.hello.dev.hellospring.model.Todo;
import com.hello.dev.hellospring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestParam String title) {
        Todo newTodo = todoService.createColumn(title);
        return ResponseEntity.ok(newTodo);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id,
                                           @RequestParam String newTitle) {
        Todo updatedTodo = todoService.updateColumn(id, newTitle);
        return (updatedTodo != null) ? ResponseEntity.ok(updatedTodo) : ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteColumn(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/status/{status}")
    public ResponseEntity<List<Todo>> listTodosByStatus(@PathVariable String status) {
        List<Todo> todos = todoService.listByStatus(status);
        return ResponseEntity.ok(todos);
    }


    @PatchMapping("/{id}/status")
    public ResponseEntity<Todo> changeTodoStatus(@PathVariable Long id,
                                                 @RequestParam String newStatus) {
        Todo updatedTodo = todoService.changeStatus(id, newStatus);
        return (updatedTodo != null) ? ResponseEntity.ok(updatedTodo) : ResponseEntity.notFound().build();
    }
}
