package com.example.kindjava.Service;

import com.example.kindjava.Model.Member;


public class IntroduceServiceImpl extends AbstIntroduceService {
    @Override
    public String introduce(Member member) {
        String name = member.getName();
        String phone = member.getPhone();
        String addr = member.getAddr();
        String introduction = "제가 사는 곳은 " + addr +
                ", 제 이름은 " + name +
                "입니다. 제 전화번호는 " + phone + " 입니다.";
        System.out.println(introduction);
        return introduction;
    }
}
