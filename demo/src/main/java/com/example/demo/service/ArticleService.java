package com.example.demo.service;

import com.example.demo.Repository.ArticleRepository;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.domain.Article;
import com.example.demo.domain.Comment;
import com.example.demo.dto.ArticleCommentRequestDto;
import com.example.demo.dto.ArticleRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository, CommentRepository commentrepository) {

        this.articleRepository = articleRepository;
        this.commentRepository = commentrepository;
    }

    public Article setArticle(ArticleRequestDto articleRequestDto){
        Article article = new Article(articleRequestDto);
        articleRepository.save(article);
        return article;
    }

    public Article getArticle(Long id){
        return articleRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
    }

    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    @Transactional
    public void setArticleComment(ArticleCommentRequestDto articleCommentRequestDto){
        Article article = articleRepository.findById(articleCommentRequestDto.getIdx()).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        Comment comment = new Comment(articleCommentRequestDto, article);
        commentRepository.save(comment);
    }
}