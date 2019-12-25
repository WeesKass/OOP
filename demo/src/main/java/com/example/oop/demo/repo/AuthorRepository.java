package com.example.oop.demo.repo;

import com.example.oop.demo.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    AuthorEntity findAuthorEntityById(Integer id);
}
