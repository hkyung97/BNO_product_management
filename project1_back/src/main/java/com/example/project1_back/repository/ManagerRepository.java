package com.example.project1_back.repository;

import com.example.project1_back.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Manager findByEmpidAndEmppassword(String empid, String emppassword);

    Manager save(Manager manager);


}


