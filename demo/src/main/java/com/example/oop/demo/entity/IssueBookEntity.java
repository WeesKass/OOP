package com.example.oop.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue_book")
public class IssueBookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "student_id")
    private Integer student;

    @Column(name = "book_id")
    private Integer book;

    @Column(name = "date")
    private Date date;

    @Column(name = "returned")
    private Boolean returned;

    @Column(name = "lastUpdate")
    private Date lastUpdate;

    @Column(name = "confirmation_code")
    private String code;

    @JsonIgnore
    private String studentIdCardAndName;
    @JsonIgnore
    private String bookName;

    public IssueBookEntity() {
    }

    public IssueBookEntity(Integer id, Integer student, Integer book, Date date, Boolean returned, Date lastUpdate, String code) {
        this.id = id;
        this.student = student;
        this.book = book;
        this.date = date;
        this.returned = returned;
        this.lastUpdate = lastUpdate;
        this.code = code;
    }

    public IssueBookEntity(String studentIdCardAndName, String bookName, Date date) {
        this.studentIdCardAndName = studentIdCardAndName;
        this.bookName = bookName;
        this.date = date;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Integer getBookEntity() {
        return book;
    }

    public void setBookEntity(Integer book) {
        this.book = book;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
