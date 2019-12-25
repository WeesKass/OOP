package com.example.oop.demo.controller;

import com.example.oop.demo.entity.BookEntity;
import com.example.oop.demo.entity.IssueBookEntity;
import com.example.oop.demo.entity.StudentEntity;
import com.example.oop.demo.repo.BookRepository;
import com.example.oop.demo.repo.IssueBookRepository;
import com.example.oop.demo.repo.StudentRepository;
import com.example.oop.demo.service.Mail;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/issue")
public class IssueBookController {

    final StudentRepository studentRepository;

    final IssueBookRepository issueBookRepository;
    
    final BookRepository bookRepository;
    
    public IssueBookController(IssueBookRepository issueBookRepository, StudentRepository studentRepository, BookRepository bookRepository) {
        this.issueBookRepository = issueBookRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    @ApiOperation("find By Issued Book Id")
    public Optional<IssueBookEntity> findById(@PathVariable("id") Integer id) {
        return issueBookRepository.findById(id);
    }

    @GetMapping("/all")
    @ApiOperation("find All Issued Books")
    public List<IssueBookEntity> findAllReturned() {
        return issueBookRepository.findAllByReturnedIsFalse();
    }

    @PostMapping("/")
    @ApiOperation("create New Issue Book")
    public IssueBookEntity createNewIssueBook(@RequestBody IssueBookEntity issueBook) {
        try {
            StudentEntity student = studentRepository.findStudentEntityById(issueBook.getStudent());
            BookEntity book =  bookRepository.findBookEntityById(issueBook.getBookEntity());
            String confirmationCode = UUID.randomUUID().toString();
            issueBook.setCode(confirmationCode);
            Mail.SendEmail(studentRepository.findStudentEntityById(issueBook.getStudent()).getEmail(), "Checked out!", String.format("Hello, %s!\nYou checked out \"%s\" Book.\n Issuance Date: %s\nPlease follow the link to confirm your check out localhost:8080/issue/confirmation/%s ! But if you didn't, please follow the next link localhost:8080/issue/undo/%s", student.getName(), book.getName(), new SimpleDateFormat("yyyy-MM-dd").format(issueBook.getDate()), confirmationCode, confirmationCode));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return issueBookRepository.save(issueBook);
    }

    @GetMapping("/confirmation/{code}")
    @ApiOperation("confirm Book Check Out")
    public String confirmBookCheckOut(@PathVariable String code){
        try {
            IssueBookEntity issueBook = issueBookRepository.findByCode(code);
            StudentEntity student = studentRepository.findStudentEntityById(issueBook.getStudent());
            BookEntity book =  bookRepository.findBookEntityById(issueBook.getBookEntity());
            Mail.SendEmail(studentRepository.findStudentEntityById(issueBook.getStudent()).getEmail(), "Checked out!", String.format("Hello, %s!\nYou confirm the \"%s\" Book.check out.\n Issuance Date: %s\nPlease to return these book in a month!\nThank you!", student.getName(), book.getName(), new SimpleDateFormat("yyyy-MM-dd").format(issueBook.getDate())));
            issueBook.setCode("null");
            return "ok";
        } catch (Exception e){
            e.printStackTrace();
        }
        return "not ok";
    }

    @GetMapping("/undo/{code}")
    @ApiOperation("wrong Book Check Out")
    public String undo(@PathVariable String code){
        try{
            IssueBookEntity issueBook = issueBookRepository.findByCode(code);
            deleteBook(issueBook.getId());
            return "ok";
        } catch (Exception e){
            e.printStackTrace();
        }
        return "not ok";
    }


    @PutMapping("/return/{id}")
    @ApiOperation("update Exist Book By Id")
    public IssueBookEntity updateExistBook(@PathVariable("id") Integer id) {
        IssueBookEntity oldBook = issueBookRepository.findIssueBookEntityById(id);
        oldBook.setReturned(true);
        return issueBookRepository.save(oldBook);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("delete Book By Id")
    public void deleteBook(@PathVariable("id") Integer id) {
        issueBookRepository.deleteById(id);
    }

}
