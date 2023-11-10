package com.example.project1_back.controller;

import com.example.project1_back.entity.Manager;
import com.example.project1_back.entity.Product;
import com.example.project1_back.repository.ManagerRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
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

            String generatedEmpid;
            do {
                // "cmp" 다음에 5자리 숫자로 생성
                generatedEmpid = generateEmpid();
            } while (managerRepository.existsByEmpid(generatedEmpid));

            manager.setEmpid(generatedEmpid);

            Manager savedManager =  managerRepository.save(manager);
            return ResponseEntity.ok("관리자 등록이 완료 되었습니다. 생성된 관리자 아이디를 기억해주세요 " + savedManager.getEmpid());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving Manager");
        }
    }

    private String generateEmpid() {
        // "cmp" 다음에 5자리 숫자로 생성
        // 실제로 중복을 검사하고 유니크한 값을 생성해야 합니다.
        // 여기에서는 단순 예시로 1부터 99999까지의 랜덤한 숫자를 사용합니다.
        int randomNumber = (int) (Math.random() * 99999) + 1;
        String empid = "emp" + String.format("%05d", randomNumber);
        return empid;
    }

    @GetMapping("/api/manager/{empid}")
    public ResponseEntity<Manager> getManagerinfo(@PathVariable("empid") String empid) {
        System.out.println(empid);

        Manager manager = managerRepository.findByempid(empid);
        if (manager != null) {
            return ResponseEntity.ok(manager);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/api/manager/{empid}")
//    public ResponseEntity<List<Manager>> getManagerinfo(@PathVariable("empid") String empid) {
//        System.out.println(empid);
//
//        // Assuming that the managerRepository has a method to fetch managers by empid and cmpid
//        List<Manager> managers = managerRepository.findManagersByEmpidAndCmpid(empid);
//
//        if (managers != null && !managers.isEmpty()) {
//            return ResponseEntity.ok(managers);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}

