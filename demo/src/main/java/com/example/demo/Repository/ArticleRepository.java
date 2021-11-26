package com.example.demo.Repository;

import com.example.demo.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Long> {
}