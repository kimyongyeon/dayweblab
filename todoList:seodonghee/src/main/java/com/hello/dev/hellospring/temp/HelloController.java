package com.hello.dev.hellospring.temp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080/api/notice/list
// restful API
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

//    public HelloController(HelloService helloService) {
//        this.helloService = helloService;
//    }

    // http://localhost/notice/list
    // http://localhost/free/list
    @GetMapping("/{subject}/list")
    public List helloList() {
        return List.of("hello", "world");
    }

    @GetMapping("/psersonList")
    public List<PersonDTO> listPerson(String param) {
        return helloService.listPerson(param);
    }
}
