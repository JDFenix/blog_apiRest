package com.example.blog_crud.service;


import com.example.blog_crud.dto.AuthorDto;
import com.example.blog_crud.model.Author;
import com.example.blog_crud.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> showAll() {
        return authorRepository.findAll();
    }

    public Author create(AuthorDto authorDto) {
        Author author = converToEntity(authorDto);
        authorRepository.save(author);
        return author;
    }

    public Author converToEntity(AuthorDto authorDto) {
        return new Author(authorDto.getUsername(), authorDto.getEmail());
    }


    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author delete(Long id) {
        Author author = findById(id);
        if (author != null) {
            authorRepository.delete(author);
        }
        return author;
    }

    public Author update(AuthorDto authorDto) {
        Author author = findById(authorDto.getId());
        if (author != null) {
            author.setEmail((authorDto.getEmail() != null) ? authorDto.getEmail() : author.getEmail());
            author.setUsername((authorDto.getUsername() != null) ? authorDto.getUsername() : author.getUsername());

            authorRepository.save(author);
        }
        return author;
    }
}
