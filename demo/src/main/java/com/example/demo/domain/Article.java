package com.example.demo.domain;

import com.example.demo.dto.ArticleRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Article extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @OneToMany(mappedBy = "article")
    private List<Tag> tags;

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    // 관심 상품 생성 시 이용합니다.
    public Article(ArticleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.tags = requestDto.getTags();
    }
}