package com.example.demo.domain;

import com.example.demo.dto.ArticleRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Article extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String tags;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column@NonNull


    @OneToMany(mappedBy="article")
    private List<Comment> comments;

    // 관심 상품 생성 시 이용합니다.
    public Article(ArticleRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.tags=requestDto.getTags();
    }

}