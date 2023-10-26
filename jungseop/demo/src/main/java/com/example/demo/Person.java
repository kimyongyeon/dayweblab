package com.example.demo;

import lombok.Getter;

@Getter
public class Person {

    private final String name;
    private final int age;
    private final String address;
    private final String job;

    public Person(String name, int age, String address, String job) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.job = job;
    }
}
