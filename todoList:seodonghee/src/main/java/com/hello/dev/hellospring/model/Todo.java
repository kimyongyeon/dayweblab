package com.hello.dev.hellospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate;

    @Column(nullable = false)
    private String status = "TODO";

    // 기본 생성자 - JPA에서 엔티티 객체를 생성할 때 필요
    public Todo() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public String getStatus() {
        return status;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        // 유효성 검사를 통해 정해진 상태만 입력되도록
        if (status.equals("TODO") || status.equals("DOING") || status.equals("DONE") || status.equals("ASAP")) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status value");
        }
    }

    // 생성 및 업데이트 시간 자동 설정을 위한 콜백 메서드들
    @PrePersist
    public void prePersist() {
        this.regDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.regDate = LocalDateTime.now();
    }
}
