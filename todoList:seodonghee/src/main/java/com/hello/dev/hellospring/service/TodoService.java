package com.hello.dev.hellospring.service;

import com.hello.dev.hellospring.model.Todo;
import com.hello.dev.hellospring.repository.DbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private DbRepository repository;

    // 1. 컬럼 문자열로 생성
    @Transactional
    public Todo createColumn(String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        return repository.add(todo);
    }

    // 2. 1번기능으로 생성한 문자열 컬럼을 수정
    @Transactional
    public Todo updateColumn(Long id, String newTitle) {
        Todo todo = repository.findById(id).orElse(null);
        if (todo != null) {
            todo.setTitle(newTitle);
            repository.update(todo);
        }
        return todo;
    }

    // 2. 1번기능으로 생성한 문자열 컬럼을 삭제
    @Transactional
    public void deleteColumn(Long id) {
        Todo todo = repository.findById(id).orElse(null);
        if (todo != null) {
            repository.delete(todo);
        }
    }

    // 4. 컬럼에 대한 "상태" 기록과 "상태"에 따라 테이블이 나누어짐
    public List<Todo> listByStatus(String status) {
        return repository.listByStatus(status);
    }

    // 5. "상태" 변경
    @Transactional
    public Todo changeStatus(Long id, String newStatus) {
        Todo todo = repository.findById(id).orElse(null);
        if (todo != null) {
            todo.setStatus(newStatus);
            repository.update(todo);
        }
        return todo;
    }
}
