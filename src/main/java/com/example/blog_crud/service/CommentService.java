package com.example.blog_crud.service;

import com.example.blog_crud.dto.CommentDto;
import com.example.blog_crud.model.Article;
import com.example.blog_crud.model.Comment;
import com.example.blog_crud.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleService articleService;

    public List<Comment> showAll() {
        return commentRepository.findAll();
    }


    public void create(CommentDto commentDto) {
        try {
            Comment comment = convertToEntity(commentDto);
            commentRepository.save(comment);
        } catch (Exception e) {

        }
    }

    public Comment convertToEntity(CommentDto commentDto) {
        Article article = articleService.findById(commentDto.getIdArticle());
        Comment comment = new Comment();
        comment.setArticle(article);
        comment.setContent(commentDto.getContent());
        return comment;
    }


    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }


    public Comment updateComment(CommentDto commentDto) {
        Comment comment = findById(commentDto.getId());
        Article article = articleService.findById(commentDto.getIdArticle());

        if (comment != null) {
            comment.setArticle(article);
            comment.setContent(commentDto.getContent());
            commentRepository.save(comment);
        }
        return comment;
    }

    public Comment delete(Long id) {
        Comment comment = findById(id);
        if (comment != null) {
            commentRepository.delete(comment);
        }
        return comment;
    }
}
