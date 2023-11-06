package com.example.kindjava.Service;

import com.example.kindjava.Model.Member;


public interface IntroduceService {

//   String introduce(Member member);

   String hiddenIntroduce(Member member);

   default String introduce1(Member member) {
      return "";
   }

   static String introduce2(Member member) {
      return "";

   }
}
