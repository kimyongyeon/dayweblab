package com.hello.dev.hellospring.domain.service;

import com.hello.dev.hellospring.domain.dto.TodoDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class TodoServiceTest {

    public static final int INT = 10;
    @Autowired
    TodoService todoService;

    @BeforeEach
    void setUp() {

        for (int i = 0; i < INT; i++) {
            String state = "";
            if (i % 2 == 0) {
                state = "준비중";
            } else if (i % 3 == 1) {
                state = "완료";
            } else {
                state = "취소";
            }

            TodoDTO build = TodoDTO.builder()
                    .id(i * 1L).state(state).regDate(LocalDateTime.now().toString()).title("테스트" + i)
                    .build();
            todoService.todoAdd(build);
        }

    }

    @Test
    void todoListTest() {
        List<TodoDTO> list = todoService.list();
        Assertions.assertEquals(list.size(), INT+1);
    }

    @Test
    @Order(1)
    @DisplayName("todoAdd 테스트")
    void todoAddTest() {
        TodoDTO build = TodoDTO.builder()
                .id(1L).state("준비중").regDate("2021-09-01").title("테스트")
                .build();
        // given
        todoService.todoAdd(build);
        // when
        TodoDTO byId = todoService.findById(1L);

        // then
        Assertions.assertEquals(byId.getState(), build.getState() + "234234234");
    }

}