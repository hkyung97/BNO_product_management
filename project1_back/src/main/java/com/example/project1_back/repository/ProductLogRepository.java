package com.example.project1_back.repository;

import com.example.project1_back.entity.ProductLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLogRepository extends JpaRepository<ProductLog, Long> {
    ProductLog save(ProductLog productLog);
}
