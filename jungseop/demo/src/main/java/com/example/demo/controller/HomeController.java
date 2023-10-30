package com.example.demo.controller;

import com.example.demo.model.person.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final List<Person> personList = new ArrayList<>();

    @GetMapping //초기 목록 5개 출력
    public String showList(Model model) {
        List<Person> initialList = getInitialList();
        model.addAttribute("list", initialList);
        return "index";
    }

    @GetMapping("/loadMore") //5개씩 추가 출력 ("더보기" 버튼 클릭 시)
    @ResponseBody
    public List<Person> loadMoreList(@RequestParam int offset) {
        List<Person> additionalList = getMoreList(offset);
        return additionalList;
    }

    @PostConstruct
    public void initList() {
        for (int i = 1; i <= 23; i++) {
            personList.add(new Person("Spring" + i, 15 + i, "Seoul" + i, "Developer" + i));
        }
    }

    private List<Person> getInitialList() {
        return personList.subList(0, 5);
    }

    private List<Person> getMoreList(int offset) {
        int startIndex = offset;
        int endIndex = Math.min(offset + 5, personList.size());
        return personList.subList(startIndex, endIndex);
    }

}
