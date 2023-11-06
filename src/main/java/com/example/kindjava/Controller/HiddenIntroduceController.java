package com.example.kindjava.Controller;

import com.example.kindjava.Model.Member;
import com.example.kindjava.Service.HiddenIntroduceService;
import com.example.kindjava.Service.HiddenIntroduceServiceImpl;
import com.example.kindjava.Service.IntroduceService;


public class HiddenIntroduceController {
//    HiddenIntroduceService hiddenIntroduceService  = new HiddenIntroduceServiceImpl();

    IntroduceService introduceService = new HiddenIntroduceServiceImpl();

    String introduce() {
        Member member = new Member("서동희", "01092001234", "서초구");
        return introduceService.hiddenIntroduce(member);
    }

}
