package com.example.oop.demo.controller;

import com.example.oop.demo.entity.BookEntity;
import com.example.oop.demo.repo.BookRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    @ApiOperation("find By Book Id")
    public Optional<BookEntity> findById(@PathVariable("id") Integer id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/")
    @ApiOperation("create New Book")
    public BookEntity createNewBook(@RequestBody BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @PutMapping("/change/{id}")
    @ApiOperation("update Exist Book By Id")
    public BookEntity updateExistBook(@PathVariable("id") Integer id, @RequestBody BookEntity newBook) {
        BookEntity oldBook = bookRepository.findBookEntityById(id);

        if (newBook.getName() == null || newBook.getName().isEmpty()) {
            newBook.setName(oldBook.getName());
        }
        if (newBook.getDesc() == null || newBook.getDesc().isEmpty()) {
            newBook.setDesc(oldBook.getDesc());
        }
        if (newBook.getLikes() == null || newBook.getLikes() == 0) {
            newBook.setLikes(oldBook.getLikes());
        }
        if (newBook.getDislikes() == null || newBook.getDislikes() == 0) {
            newBook.setDislikes(oldBook.getDislikes());
        }
        if (newBook.getAuthorEntity() == null || newBook.getAuthorEntity().isEmpty()) {
            newBook.setAuthorEntity(oldBook.getAuthorEntity());
        }
        if (newBook.getPublisherId() == null || newBook.getPublisherId() == 0) {
            newBook.setPublisherId(oldBook.getPublisherId());
        }
        if (newBook.getDate() == null) {
            newBook.setDate(oldBook.getDate());
        }
        newBook.setId(id);
        return bookRepository.save(newBook);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete Book By Id")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookRepository.deleteById(id);
    }

}
