package com.example.project1_back.repository;

import com.example.project1_back.entity.Payment;
import com.example.project1_back.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment save(Payment payment);
}
