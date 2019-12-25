package com.example.oop.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "id_card")
    private String idCard;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private List<IssueBookEntity> issueBooks;


    public StudentEntity() {
    }

    public StudentEntity(Integer id, String name, String surname, String email, String idCard, List<IssueBookEntity> issueBooks) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.idCard = idCard;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public List<IssueBookEntity> getIssueBooks() {
        return issueBooks;
    }

    public void setIssueBooks(List<IssueBookEntity> issueBooks) {
        this.issueBooks = issueBooks;
    }
}
