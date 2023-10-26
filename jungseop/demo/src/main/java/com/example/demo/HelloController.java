package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/list")
    public PeopleDto personList() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Spring1", 15, "Seoul1", "Developer1"));
        list.add(new Person("Spring2", 16, "Seoul2", "Developer2"));
        list.add(new Person("Spring3", 17, "Seoul3", "Developer3"));

        return new PeopleDto(list);
    }

}
