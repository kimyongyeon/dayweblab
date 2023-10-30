package com.example.demo.model.todo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDto {
    private String title;
    private String regDate;
    private boolean comYn;
}
