package com.example.kindjava.Controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KindJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KindJavaApplication.class, args);

        IntroduceController controller = new IntroduceController();
        controller.introduce();


        HiddenIntroduceController HController = new HiddenIntroduceController();
        HController.introduce();
    }

}
