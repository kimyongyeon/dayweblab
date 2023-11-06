package com.example.kindjava.Controller;

import com.example.kindjava.Model.Member;
import com.example.kindjava.Service.HiddenIntroduceService;
import com.example.kindjava.Service.HiddenIntroduceServiceImpl;


public class HiddenIntroduceController {
    HiddenIntroduceService hiddenIntroduceService  = new HiddenIntroduceServiceImpl();

    String introduce() {
        Member member = new Member("서동희", "01092001234", "서초구");
        return hiddenIntroduceService.hiddenIntroduce(member);
    }

}
