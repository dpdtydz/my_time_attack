package com.example.demo.controller;


import com.example.demo.Repository.ArticleRepository;
import com.example.demo.domain.Article;
import com.example.demo.dto.ArticleCommentRequestDto;
import com.example.demo.dto.ArticleRequestDto;
import com.example.demo.service.ArticleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleRepository articleRepository;

    @PostMapping("/article")
    public Article setArticle(@RequestBody ArticleRequestDto articleRequestDto){
        return articleService.setArticle(articleRequestDto);
    }

    @GetMapping("/articles")
    public List<Article> getArticles(){
        return articleService.getArticles();
    }

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable Long id){
        return articleService.getArticle(id);
    }


    @PostMapping("/article/comment")
    public void setArticleComment(@RequestBody ArticleCommentRequestDto commentRequestDto){
        articleService.setArticleComment(commentRequestDto);
    }

}