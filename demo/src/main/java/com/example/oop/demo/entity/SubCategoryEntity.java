package com.example.oop.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sub_category")
public class SubCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_category_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "category_id")
    private Integer categoryId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "sub_category_id", referencedColumnName = "sub_category_id")
    private List<BookEntity> book;


    public SubCategoryEntity() {
    }

    public SubCategoryEntity(String name, String description, Boolean isActive, List<BookEntity> book, Integer categoryId) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.book = book;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getCategory_id() {
        return categoryId;
    }

    public void setCategory_id(Integer categoryId) {
        this.categoryId = categoryId;
    }


    public List<BookEntity> getProduct() {
        return book;
    }

    public void setProduct(List<BookEntity> book) {
        this.book = book;
    }
}
