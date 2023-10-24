package com.hello.dev.hellospringstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class HelloSpringStudyApplication {

    @CrossOrigin( maxAge = 3600)
    @RestController
//    @Controller
    public static class MyController {
        @GetMapping("/")
//        @ResponseBody
        public String hello() {
            return "Hello Spring";
        }

        @GetMapping("/{name}")
        public String hello2(@PathVariable String name) {
            return String.format("Hello, %s", name);
        }

        /**
         * curl -X GET "http://localhost:9000/param?name=Spring"
         * @param name
         * @return
         */
        @GetMapping("/param")
        public String hello3(@RequestParam String name) {
            return String.format("Hello, %s", name);
        }

        @GetMapping("/list")
        public Map<String, Object> hello4() {
            List<Person> list = new ArrayList<>();
            list.add(new Person("Spring1", 11, "Seoul1", "Developer1"));
            list.add(new Person("Spring2", 12, "Seoul2", "Developer2"));
            list.add(new Person("Spring3", 13, "Seoul3", "Developer3"));
            return ResultDTO.result(list);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringStudyApplication.class, args);
    }

}