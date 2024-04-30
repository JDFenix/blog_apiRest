package com.example.blog_crud.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private  Long id;
    private String username;
    private String email;
}
