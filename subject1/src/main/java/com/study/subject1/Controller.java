package com.study.subject1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Controller
public class Controller {
    /*
    @RequestMapping(value = "/index")
    public String index() {
        return "index.html";
    }*/

    @GetMapping("Api")
    @ResponseBody
    public Api api() {
        Api api = new Api();
        api.setTitle("백앤드");
        api.setState("완료");
        api.setRegDate("2023-10-01");

        return api;
    }



}
