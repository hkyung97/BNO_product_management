package com.example.project1_back.repository;

import com.example.project1_back.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, String> {
    Product save(Product product);

    // 메서드 이름을 따라 자동 생성하도록 허용
    Product findByPrdid(String prdid);
}
