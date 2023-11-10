package com.example.project1_back.repository;

import com.example.project1_back.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Company save(Company company);

    boolean existsByCmpid(String cmpid);

    Company findBycmpid(String cmpid);


}


