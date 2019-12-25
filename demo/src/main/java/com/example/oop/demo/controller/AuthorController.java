package com.example.oop.demo.controller;

import com.example.oop.demo.entity.AuthorEntity;
import com.example.oop.demo.repo.AuthorRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/{id}")
    @ApiOperation("find Author By Id")
    public Optional<AuthorEntity> findById(@PathVariable("id") Integer id) {
        return authorRepository.findById(id);
    }

    @PostMapping("/")
    @ApiOperation("create New Author")
    public AuthorEntity createNewAuthor(@RequestBody AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    @PutMapping("/change/{id}")
    @ApiOperation("update Exist Author By Id")
    public AuthorEntity updateExistAuthor(@PathVariable("id") Integer id, @RequestBody AuthorEntity newAuthor) {
        AuthorEntity oldAuthor = authorRepository.findAuthorEntityById(id);

        if (newAuthor.getName() == null || newAuthor.getName().isEmpty()) {
            newAuthor.setName(oldAuthor.getName());
        }
        if (newAuthor.getSurname() == null || newAuthor.getSurname().isEmpty()) {
            newAuthor.setSurname(oldAuthor.getSurname());
        }
        if (newAuthor.getDate() == null) {
            newAuthor.setDate(oldAuthor.getDate());
        }
        if (newAuthor.getBookId() == null) {
            newAuthor.setBookId(oldAuthor.getBookId());
        }
        newAuthor.setId(id);
        return authorRepository.save(newAuthor);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete Author By Id")
    public void deleteAuthor(@PathVariable("id") Integer id) {
        authorRepository.deleteById(id);
    }
}
