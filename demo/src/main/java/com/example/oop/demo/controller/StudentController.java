package com.example.oop.demo.controller;

import com.example.oop.demo.entity.StudentEntity;
import com.example.oop.demo.entity.StudentEntity;
import com.example.oop.demo.repo.StudentRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{id}")
    @ApiOperation("find Student By Id")
    public Optional<StudentEntity> findById(@PathVariable("id") Integer id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/")
    @ApiOperation("create New Student")
    public StudentEntity createNewStudent(@RequestBody StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @PutMapping("/change/{id}")
    @ApiOperation("update Exist Student By Id")
    public StudentEntity updateExistStudent(@PathVariable("id") Integer id, @RequestBody StudentEntity newStudent) {
        StudentEntity oldStudent = studentRepository.findStudentEntityById(id);

        if (newStudent.getName() == null || newStudent.getName().isEmpty()) {
            newStudent.setName(oldStudent.getName());
        }
        if (newStudent.getSurname() == null || newStudent.getSurname().isEmpty()) {
            newStudent.setSurname(oldStudent.getSurname());
        }
        if (newStudent.getEmail() == null || newStudent.getEmail().isEmpty()) {
            newStudent.setEmail(oldStudent.getEmail());
        }
        if (newStudent.getIdCard() == null || newStudent.getIdCard().isEmpty()) {
            newStudent.setIdCard(oldStudent.getIdCard());
        }
        if (newStudent.getIssueBooks() == null || newStudent.getIssueBooks().isEmpty()) {
            newStudent.setIssueBooks(oldStudent.getIssueBooks());
        }
        newStudent.setId(id);
        return studentRepository.save(newStudent);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete Student By Id")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
    }

}
