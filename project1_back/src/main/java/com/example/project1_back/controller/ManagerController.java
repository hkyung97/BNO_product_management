package com.example.project1_back.controller;

import com.example.project1_back.entity.Manager;
import com.example.project1_back.repository.ManagerRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.util.Map;

@RestController
public class ManagerController {

    @Autowired
    ManagerRepository managerRepository;

    @PostMapping("/api/manager/login")
    public String login(@RequestBody Map<String, String> params,
                        HttpServletResponse res) { //@RequestBody요청일 때의 json 규칙 Map<String, String>
        Manager manager = managerRepository.findByEmpidAndEmppassword(params.get("empid"), params.get("emppassword"));
        System.out.println(manager);
        if (manager != null) {
            return manager.getEmpid();
        }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/api/manager/add")
    public ResponseEntity<String> addManager(@RequestBody Manager manager) {
        try {
            Manager savedManager =  managerRepository.save(manager);
            return ResponseEntity.ok("회원가입이 완료 되었습니다. 관리자권한으로 이용이 가능합니다." + savedManager.getEmpid());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving Manager");
        }
    }
}

