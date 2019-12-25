package com.example.oop.demo.controller;

import com.example.oop.demo.entity.PublisherEntity;
import com.example.oop.demo.repo.PublisherRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/{id}")
    @ApiOperation("find Publisher By Id")
    public Optional<PublisherEntity> getPublisherById(@PathVariable("id") Integer id) {
        return publisherRepository.findById(id);
    }

    @PostMapping("/")
    @ApiOperation("create New Publisher")
    public PublisherEntity createNewPublisher(@RequestBody PublisherEntity publisherEntity) {
        return publisherRepository.save(publisherEntity);
    }

    @PutMapping("/change/{id}")
    @ApiOperation("update Exist Publisher By Id")
    public PublisherEntity updateExistPublisher(@PathVariable("id") Integer id, @RequestBody PublisherEntity newPublisher) {
        PublisherEntity oldPublisher = publisherRepository.findPublisherEntityById(id);

        if (newPublisher.getName() == null || newPublisher.getName().isEmpty()) {
            newPublisher.setName(oldPublisher.getName());
        }
        if (newPublisher.getBooks() == null || newPublisher.getBooks().isEmpty()) {
            newPublisher.setBooks(oldPublisher.getBooks());
        }
        newPublisher.setId(id);
        return publisherRepository.save(newPublisher);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete Publisher By Id")
    public void deletePublisher(@PathVariable("id") Integer id) {
        publisherRepository.deleteById(id);
    }
}
