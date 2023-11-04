package com.example.kindjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KindJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KindJavaApplication.class, args);
        Member member =new Member();
        member.introduce("서동희","01000000000","강남구");
        member.hiddenIntroduce("서동희","01099998888","강남구");

    }

}
