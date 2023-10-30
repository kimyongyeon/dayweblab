package com.hello.dev.hellospring.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDTO {
    private Long id;
    private String title;
    private String regDate;
    private String state;
}
