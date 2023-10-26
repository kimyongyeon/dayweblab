package com.hello.dev.hellospringstudy;

import java.util.List;

public class ResultDTO {

    private List<Person> list;

    public ResultDTO(List<Person> list){
        this.list = list;
    }

    public List<Person> getList() {
        return list;
    }

    public void setList(List<Person> list) {
        this.list = list;
    }
}
