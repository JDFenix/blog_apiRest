package com.example.blog_crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private String content;

    public Comment(Article article, String content){
        this.content =content;
        this.article =article;
    }

    public Comment() {

    }
}
