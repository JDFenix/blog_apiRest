package com.example.blog_crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    public Article(Author author){
        this.author=author;
    }

    public Article(){

    }
}
