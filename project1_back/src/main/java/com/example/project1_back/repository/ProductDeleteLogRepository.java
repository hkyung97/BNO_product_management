package com.example.project1_back.repository;

import com.example.project1_back.entity.ProductDeleteLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDeleteLogRepository extends JpaRepository<ProductDeleteLog, Long> {
    ProductDeleteLog save(ProductDeleteLog productDeleteLog);
}
