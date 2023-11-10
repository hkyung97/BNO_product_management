package com.example.project1_back.repository;

import com.example.project1_back.entity.Manager;
import com.example.project1_back.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Manager findByEmpidAndEmppassword(String empid, String emppassword);

    Manager save(Manager manager);

    Manager findByempid(String empid);

    boolean existsByEmpid(String empid);

//    @Query("SELECT m FROM Manager m JOIN FETCH m.company c WHERE c.cmpid = :cmpid")
//    List<Manager> findManagersByEmpidAndCmpid(@Param("empid") String empid);


}


