package com.example.demo.Repository;

import com.example.demo.domain.Tag;
import com.example.demo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
