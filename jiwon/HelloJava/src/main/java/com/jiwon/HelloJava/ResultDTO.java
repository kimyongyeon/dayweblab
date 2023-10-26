package com.jiwon.HelloJava;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ResultDTO {
    private List<Person> list;
    public List<Person> getList(){
        return list;
    }

    public ResultDTO(List<Person> list) {
        this.list = list;
    }
}
