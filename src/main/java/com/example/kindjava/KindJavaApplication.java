package com.example.kindjava;


import com.example.kindjava.Controller.HiddenIntroduceController;
import com.example.kindjava.Controller.IntroduceController;
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
