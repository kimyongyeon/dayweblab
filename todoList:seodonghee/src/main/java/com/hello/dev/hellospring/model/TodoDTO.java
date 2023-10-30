package com.hello.dev.hellospring.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDTO {
    private Long id;
    private String title;
    private String regDate;
    private TodoStatus status;
}
