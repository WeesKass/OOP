package com.example.oop.demo.controller;

import com.example.oop.demo.entity.CategoryEntity;
import com.example.oop.demo.exception.RecordNotFoundException;
import com.example.oop.demo.repo.CategoryRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/{id}")
    @ApiOperation(value = "find Category By Id")
    public CategoryEntity findCategoryById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return categoryRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    @GetMapping("/all")
    @ApiOperation(value = "find All Category")
    public List<CategoryEntity> findAllCategory(){
        return categoryRepository.findAll();
    }

    @PostMapping("/")
    @ApiOperation(value = "save Category")
    public CategoryEntity saveCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "change Category")
    public CategoryEntity changeCategory(@RequestBody CategoryEntity newCategory, @PathVariable Integer id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    //category.setName((newCategory.getName() == null) ? Category.getName() : newCategory.getName());
                    category.setName(newCategory.getName());
                    category.setDescription(newCategory.getDescription());
                    category.setActive(newCategory.isActive());
                    return categoryRepository.save(category);
                })
                .orElseGet(() -> {
                    newCategory.setId(id);
                    return categoryRepository.save(newCategory);
                });
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete Category By Id")
    public String deleteCategoryById(@PathVariable("id") Integer id ){
        categoryRepository.deleteById(id);
        return String.format("Deleted Category #%d", id);
    }
}
