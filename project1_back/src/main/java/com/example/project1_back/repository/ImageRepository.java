package com.example.project1_back.repository;

import com.example.project1_back.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Manager, Integer> {
}
