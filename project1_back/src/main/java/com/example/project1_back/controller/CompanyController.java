package com.example.project1_back.controller;

import com.example.project1_back.entity.Company;


import com.example.project1_back.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @PostMapping("/api/company/add")
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        try {

            String generatedCmpid;
            do {
                // "cmp" 다음에 5자리 숫자로 생성
                generatedCmpid = generateCmpid();
            } while (companyRepository.existsByCmpid(generatedCmpid));

            company.setCmpid(generatedCmpid);

            Company savedCompany = companyRepository.save(company);
            return ResponseEntity.ok(savedCompany.getCmpname() + " 의 회사등록이 정상 처리되었습니다." );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving Company");
        }
    }

    private String generateCmpid() {
        // "cmp" 다음에 5자리 숫자로 생성
        // 실제로 중복을 검사하고 유니크한 값을 생성해야 합니다.
        // 여기에서는 단순 예시로 1부터 99999까지의 랜덤한 숫자를 사용합니다.
        int randomNumber = (int) (Math.random() * 99999) + 1;
        String cmpid = "cmp" + String.format("%05d", randomNumber);
        return cmpid;
    }
}

