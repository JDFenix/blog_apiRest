package com.example.blog_crud.controller;

import com.example.blog_crud.dto.ArticleDto;
import com.example.blog_crud.model.Article;
import com.example.blog_crud.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/showAll")
    public List<Article> showAll() {
        return articleService.showAll();
    }


    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody ArticleDto articleDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Article article = articleService.create(articleDto);

            response.put("successful", article);
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }


    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody ArticleDto articleDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Article article = articleService.update(articleDto);
            if (article.getId() != null) {
                response.put("successful", article);
            }
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/delete")
    public Map<String, Object> delete(@RequestBody ArticleDto articleDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Article article = articleService.delete(articleDto);
            if (article != null) {
                response.put("successful", "se elimino correctamente");
            }
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }
}
