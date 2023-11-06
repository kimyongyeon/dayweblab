package com.example.kindjava.Service;

import com.example.kindjava.Model.Member;



public class HiddenIntroduceServiceImpl extends AbstIntroduceService {

    String getHiddenPhone(Member member){
        String phone= member.getPhone();
        int visibleNumber = 7;
        String hiddenData = phone.substring(0, visibleNumber);
        for (int i = 0; i < phone.length() - visibleNumber; i++) {
            hiddenData += "*";
        }
        return hiddenData;
    }


    @Override
    public String hiddenIntroduce(Member member) {
        String name = member.getName();
        String hiddenPhone = getHiddenPhone(member);
        String addr = member.getAddr();
        String introduction = "제가 사는 곳은 " + addr +
                ", 제 이름은 " + name +
                "입니다. 제 전화번호는 " + hiddenPhone + " 입니다.";
        System.out.println(introduction);
        return introduction;
    }
}
