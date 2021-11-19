package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter // Lombok이 getter 자동 생성
@Entity // 테이블과 연계되는 클래스임을 스프링에게 알려줌
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 생성하도록 상속받음

    @GeneratedValue(strategy = GenerationType.AUTO) // ID 생성시 자동으로 증가
    @Id // ID 값, PK로 사용하겠다는 의미
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String title;

}