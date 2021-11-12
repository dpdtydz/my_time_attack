package com.example.demo.domain;

import com.example.demo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자 대신 생성
@Getter // Lombok이 getter 자동 생성
@Entity // 테이블과 연계되는 클래스임을 스프링에게 알려줌
public class Memo { // 생성,수정 시간을 자동으로 생성하도록 상속받음
    @GeneratedValue(strategy = GenerationType.AUTO) // ID 생성시 자동으로 증가
    @Id // ID 값, PK로 사용하겠다는 의미
    private Long id;

    @Column(nullable = false)
    private String contents;

    // 생성자
    public Memo(String contents) {
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto) {
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.contents = requestDto.getContents();
    }
}