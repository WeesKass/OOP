package com.example.oop.demo.repo;

import com.example.oop.demo.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherEntity, Integer> {
    PublisherEntity findPublisherEntityById(Integer id);
}