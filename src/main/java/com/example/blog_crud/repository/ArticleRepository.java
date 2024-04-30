package com.example.blog_crud.repository;

import com.example.blog_crud.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
