package com.example.oop.demo.controller;

import com.example.oop.demo.entity.SubCategoryEntity;
import com.example.oop.demo.exception.RecordNotFoundException;
import com.example.oop.demo.repo.SubCategoryRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subCategory")
@CrossOrigin
public class SubCategoryController {
    @Autowired
    SubCategoryRepository subCategoryRepository;

    @GetMapping("/{id}")
    @ApiOperation(value = "find SubCategory By Id")
    public SubCategoryEntity findSubCategoryById(@PathVariable("id") Integer id) throws RecordNotFoundException {
        return subCategoryRepository.findById(id).orElseThrow(RecordNotFoundException::new);
    }


    @GetMapping("/all")
    @ApiOperation(value = "find All SubCategory")
    public List<SubCategoryEntity> findAllSubCategory() {
        return subCategoryRepository.findAll();
    }

    @PostMapping("/")
    @ApiOperation(value = "change SubCategory")
    public SubCategoryEntity saveSubCategory(@RequestBody SubCategoryEntity subCategoryEntity) {
        return subCategoryRepository.save(subCategoryEntity);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "save SubCategory")
    public SubCategoryEntity changeSubCategory(@RequestBody SubCategoryEntity newSubCategory, @PathVariable Integer id) {
        return subCategoryRepository.findById(id)
                .map(subCategory -> {
                    //subCategory.setName((newSubCategory.getName() == null) ? subCategory.getName() : newSubCategory.getName());
                    subCategory.setName(newSubCategory.getName());
                    subCategory.setDescription(newSubCategory.getDescription());
                    subCategory.setActive(newSubCategory.isActive());
//                    subCategory.setCategory_id(newSubCategory.getCategory_id());
                    return subCategoryRepository.save(subCategory);
                })
                .orElseGet(() -> {
//                    newSubCategory.setId(id);
                    return subCategoryRepository.save(newSubCategory);
                });
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "delete SubCategory By Id")
    public String deleteSubCategoryById(@PathVariable("id") Integer id) {
        subCategoryRepository.deleteById(id);
        return String.format("Deleted SubCategory #%d", id);
    }
}
