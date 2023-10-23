package com.example.demo.todo;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Content {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm");

    private final String title;
    private final String state;
    private final String regData;

    public Content(String title, String state) {
        this.title = title;
        this.state = state;
        this.regData = LocalDateTime.now().format(FORMATTER);
    }
}
