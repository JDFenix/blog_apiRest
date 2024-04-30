package com.example.blog_crud.controller;

import com.example.blog_crud.dto.AuthorDto;
import com.example.blog_crud.model.Author;
import com.example.blog_crud.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;


    @GetMapping("/showAll")
    public List<Author> showAll() {
        return authorService.showAll();
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody AuthorDto authorDto) {
        Map<String, Object> response = new HashMap<>();
        try {
          Author author=  authorService.create(authorDto);

            response.put("successful", author);
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }

    @DeleteMapping("/delete")
    public Map<String, Object> delete(@RequestBody AuthorDto authorDto) {
        Map<String, Object> response = new HashMap<>();

        Author author = authorService.delete(authorDto.getId());
        if (author != null) {
            response.put("successful", "se elimino correctamente");
        } else {
            response.put("error", "No se encontro un autor con el id ingresado");
        }
        return response;
    }


    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody AuthorDto authorDto) {
        Map<String, Object> response = new HashMap<>();
        try {
            Author author = authorService.update(authorDto);

            if (author!=null){
                response.put("successful", author);
            }else{
                response.put("error", "no se encontro un autor con el id ingresado");
            }
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }


}
