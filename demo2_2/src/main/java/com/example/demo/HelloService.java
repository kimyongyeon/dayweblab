package com.example.demo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloService {

    public List<PersonDTO> getPersonList() {
        List<PersonDTO> myList = new ArrayList<PersonDTO>();
        myList.add(new Person("Spring1", 15, "Seoul1", "Developer1").toPersonDTO());
        myList.add(new Person("Spring2", 16, "Seoul2", "Developer2").toPersonDTO());
        myList.add(new Person("Spring3", 17, "Seoul3", "Developer3").toPersonDTO());
        return myList;
    }
}


