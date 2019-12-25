package com.example.oop.demo.repo;

import com.example.oop.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findBookEntityById(Integer id);
    List<BookEntity> findByNameContaining(String name);
    List<BookEntity> findByDateBetween(Date from, Date to);
}
