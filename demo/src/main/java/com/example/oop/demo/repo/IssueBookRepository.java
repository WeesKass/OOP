package com.example.oop.demo.repo;

import com.example.oop.demo.entity.IssueBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueBookRepository extends JpaRepository<IssueBookEntity, Integer> {
    IssueBookEntity findIssueBookEntityById(Integer id);
    List<IssueBookEntity> findAllByReturnedIsFalse();
    IssueBookEntity findByCode(String code);
}
