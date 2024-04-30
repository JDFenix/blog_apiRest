package com.example.blog_crud.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column(unique = true)
    private String email;


    public Author(String username, String email){
        this.email=email;
        this.username=username;
    }

    public Author() {

    }
}
