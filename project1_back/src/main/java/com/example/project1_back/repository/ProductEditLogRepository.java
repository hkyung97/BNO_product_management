package com.example.project1_back.repository;

import com.example.project1_back.entity.ProductEditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEditLogRepository extends JpaRepository<ProductEditLog, Long> {
    ProductEditLog save(ProductEditLog productEditLog);
}
