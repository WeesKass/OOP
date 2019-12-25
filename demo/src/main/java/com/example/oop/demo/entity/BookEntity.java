package com.example.oop.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "descript")
    private String desc;

    @Column(name = "date")
    private Date date;

    @Column(name = "likes")
    private Integer likes;

    @Column(name = "dislikes")
    private Integer dislikes;

    @Column(name = "in_stock")
    private boolean inStock;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private List<AuthorEntity> authors;

    @Column(name = "publisher_id")
    private Integer publisherId;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private List<IssueBookEntity> issueBooks;

    public BookEntity() {
    }

    public BookEntity(String name, String desc, Date date, Integer likes, Integer dislikes, boolean inStock, List<AuthorEntity> authors, Integer publisherId, List<IssueBookEntity> issueBooks) {
        this.name = name;
        this.desc = desc;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
        this.inStock = inStock;
        this.authors = authors;
        this.publisherId = publisherId;
        this.issueBooks = issueBooks;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public List<AuthorEntity> getAuthorEntity() {
        return authors;
    }

    public void setAuthorEntity(List<AuthorEntity> authors) {
        this.authors = authors;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public List<IssueBookEntity> getIssueBooks() {
        return issueBooks;
    }

    public void setIssueBooks(List<IssueBookEntity> issueBooks) {
        this.issueBooks = issueBooks;
    }
}
