package com.example.demo;

import com.example.demo.todo.Content;
import com.example.demo.todo.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/todo")
    public Todo todoApi() {
        List<Content> contents = new ArrayList<>();
        contents.add(new Content("백엔드 개발중 입니다.", "시작 전"));
        contents.add(new Content("백엔드 개발중 입니다..", "진행중"));
        contents.add(new Content("백엔드 개발중 입니다...", "완료"));
        Todo todo = new Todo(contents);

        return todo;
    }
}
