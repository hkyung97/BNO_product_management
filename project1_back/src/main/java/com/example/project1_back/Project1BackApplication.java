package com.example.project1_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:8080")
public class Project1BackApplication {

    public static void main(String[] args) {
        SpringApplication.run(Project1BackApplication.class, args);
    }

}
