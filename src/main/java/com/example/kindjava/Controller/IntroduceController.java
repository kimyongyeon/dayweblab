package com.example.kindjava.Controller;

import com.example.kindjava.Model.Member;

import com.example.kindjava.Service.IntroduceService;
import com.example.kindjava.Service.IntroduceServiceImpl;




public class IntroduceController {
    IntroduceService introduceService = new IntroduceServiceImpl();

    String introduce() {
        Member member = new Member("서동희", "01092001234", "서초구");
        return introduceService.introduce(member);
    }


}