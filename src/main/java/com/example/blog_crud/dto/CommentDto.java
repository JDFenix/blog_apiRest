package com.example.blog_crud.dto;


import com.example.blog_crud.model.Article;
import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private Long idArticle;
    private String content;

}
