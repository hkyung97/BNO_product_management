package com.example.project1_back.repository;

import com.example.project1_back.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByempid(String empid);

    Manager save(Manager manager);

}

