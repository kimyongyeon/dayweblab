package com.example.demo;

import com.example.demo.Person;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PeopleDto {

    private List<Person> list;

    public PeopleDto(List<Person> list) {
        this.list = list;
    }
}
