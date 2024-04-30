package com.example.blog_crud.controller;

import com.example.blog_crud.dto.CommentDto;
import com.example.blog_crud.model.Comment;
import com.example.blog_crud.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import java.util.List;


@RestController
@RequestMapping("/Comment")
public class CommentController {
    @Autowired
    private CommentService commentService;


    @GetMapping("/showAll")
    public List<Comment> showAll() {

        return commentService.showAll();
    }


    @PostMapping("/create")
    public Map<String, Object> createComment(@RequestBody CommentDto commentDto) {
        Map<String, Object> response = new HashMap<>();

        try {
            commentService.create(commentDto);
            response.put("successful", commentDto);
        } catch (Exception e) {
            response.put("error", commentDto);
        }
        return response;
    }


    @PutMapping("/update")
    public Map<String, Object> updateComment(@RequestBody CommentDto commentDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Comment comment = commentService.updateComment(commentDto);

            if (comment != null) {
                response.put("successful", comment);
            }else {
                response.put("error no se encontro el id", commentDto.getId());
            }


        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }


    @DeleteMapping("/delete")
    public Map<String, Object> delete(@RequestBody CommentDto commentDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Comment comment = commentService.delete(commentDto.getId());
            if (comment != null) {
                response.put("successful", "borrado exitosamente");
            }else{
                response.put("error no se encontro un comentario con el id",commentDto.getId());
            }

        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }

}
