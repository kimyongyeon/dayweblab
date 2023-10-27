package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class PersonDTO {
    private String name;
    private int age;
    private String location;
    private String occupation;


    public PersonDTO(String name, int age, String location, String occupation) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.occupation = occupation;
    }
}

