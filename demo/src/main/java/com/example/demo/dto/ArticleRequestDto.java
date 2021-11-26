package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import com.example.demo.domain.Article;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Tag;

import java.util.List;

@Setter
@Getter
public class ArticleRequestDto {
    private String title;
    private String content;
    private List<Tag> tags;
}