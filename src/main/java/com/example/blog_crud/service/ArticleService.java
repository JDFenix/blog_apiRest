package com.example.blog_crud.service;

import com.example.blog_crud.dto.ArticleDto;
import com.example.blog_crud.model.Article;
import com.example.blog_crud.model.Author;
import com.example.blog_crud.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorService authorService;

    public List<Article> showAll() {
        return articleRepository.findAll();
    }

    public Article findById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article convertToEntity(ArticleDto articleDto) {
        Author author = authorService.findById(articleDto.getIdAuthor());
        return new Article(author);

    }


    public Article create(ArticleDto articleDto) {
        Article article = convertToEntity(articleDto);
        articleRepository.save(article);
        return article;
    }


    public Article update(ArticleDto articleDto) {
        Article article = findById(articleDto.getId());
        Author author = authorService.findById(articleDto.getIdAuthor());

        if (article != null) {
            article.setAuthor((article != null && author!=null) ? author : article.getAuthor());
            articleRepository.save(article);
        }
        return article;
    }

    public Article delete(ArticleDto articleDto) {
        Article article = findById(articleDto.getId());
        if (article != null) {
       articleRepository.delete(article);
        }
        return article;
    }

}
