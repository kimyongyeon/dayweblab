package com.example.demo.todo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class Todo {

    private final List<Content> TodoList;

}
