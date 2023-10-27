package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public ModelAndView hello(@ModelAttribute("personList") List<PersonDTO> personList) {
        ModelAndView modelAndView = new ModelAndView("hello");
        return modelAndView;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<PersonDTO> personList(@RequestParam(required = false) String param) {
        if (param != null) {
            return performCustomLogic(param);
        } else {
            return helloService.getPersonList();
        }
    }

    private List<PersonDTO> performCustomLogic(String param) {
        return helloService.getPersonList();
    }
}

