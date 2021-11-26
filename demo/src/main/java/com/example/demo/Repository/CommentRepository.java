package com.example.demo.Repository;

import com.example.demo.domain.Article;
import com.example.demo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
