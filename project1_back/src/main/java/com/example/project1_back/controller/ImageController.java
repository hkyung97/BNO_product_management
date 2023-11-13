package com.example.project1_back.controller;

import com.example.project1_back.repository.ImageRepository;
import com.example.project1_back.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.project1_back.entity.Product;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

@RestController
public class ImageController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/api/upload/image")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String uploadDir = "C:/Users/bnosoft/hk/Product_Management/project1_front/public/img";
            // 이미지를 저장하고 저장된 경로를 응답으로 보냄
            String imgpath = saveImage(file, uploadDir);
//            System.out.println(imgpath);
            return ResponseEntity.ok(Map.of("imgpath", imgpath));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
        }
    }

    private String saveImage(MultipartFile file, String uploadDir) throws IOException {
        // 이미지를 저장하는 로직을 구현
        // 예시: 이미지를 서버의 특정 폴더에 저장하고 해당 경로를 반환
        String uniqueFileName = UUID.randomUUID().toString() + file.getOriginalFilename();
        String imgpath = Paths.get(uploadDir, uniqueFileName).toString();

        // 이미지를 저장
        Files.copy(file.getInputStream(), Paths.get(imgpath), StandardCopyOption.REPLACE_EXISTING);
        System.out.println(imgpath);
        return imgpath;
    }
}





