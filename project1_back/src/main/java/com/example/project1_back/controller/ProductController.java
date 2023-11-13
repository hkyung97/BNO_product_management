package com.example.project1_back.controller;

import com.example.project1_back.entity.Product;
import com.example.project1_back.entity.ProductDeleteLog;
import com.example.project1_back.repository.ProductDeleteLogRepository;
import com.example.project1_back.repository.ProductEditLogRepository;
import com.example.project1_back.repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDeleteLogRepository productDeleteLogRepository;
    @Autowired
    ProductEditLogRepository productEditLogRepository;

    @GetMapping("/api/products")
    public List<Product> getProducts() { //entity에 있는 Product(dto개념)가 여기서의 Product
        List<Product> products = productRepository.findAll();
        return products;
    }




    @PostMapping("/api/products/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        try {

            String generatedPrdid;
            do {
                generatedPrdid = generatePrdid();
            } while (productRepository.existsByPrdid(generatedPrdid));

            product.setPrdid(generatedPrdid);

            Product savedProduct = productRepository.save(product);
            return ResponseEntity.ok("Product saved with ID: " + savedProduct.getPrdid());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving product");
        }
    }

    public String generatePrdid() {
        // "cmp" 다음에 5자리 숫자로 생성
        // 실제로 중복을 검사하고 유니크한 값을 생성해야 합니다.
        // 여기에서는 단순 예시로 1부터 99999까지의 랜덤한 숫자를 사용합니다.
        int randomNumber = (int) (Math.random() * 99999) + 1;
        String prdid = "prd" + String.format("%05d", randomNumber);
        return prdid;
    }

    @GetMapping("/api/products/{prdid}")
    public ResponseEntity<Product> getOneProduct(@PathVariable("prdid") String prdid) {
        System.out.println(prdid);

        Product product = productRepository.findByPrdid(prdid);
//        System.out.println(product);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/products/{prdid}")
    public ResponseEntity<String> deleteProductById(
            @PathVariable("prdid") String prdid,
            @RequestBody Map<String, String> data){
        try {
            // 세션에서 사용자 ID 가져오기
//            HttpSession session = request.getSession();
////            String empid = (String) session.getAttribute("empid");
////            System.out.println(session.getAttribute(""));

            String empid = data.get("empid");
            System.out.println(empid);
            // 로그 디비에 저장
            ProductDeleteLog productDeleteLog = new ProductDeleteLog();
            productDeleteLog.setEmpid(empid);
            productDeleteLog.setPrdid(prdid);
            productDeleteLog.setActivitytime(LocalDateTime.now());
            productDeleteLogRepository.saveAndFlush(productDeleteLog);
            productRepository.deleteById(prdid);

            return ResponseEntity.ok(prdid + " 가 삭제 되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting product");
        }
    }

    @PutMapping("/api/products/{prdid}")
    public ResponseEntity<String> editProduct(@PathVariable String prdid, @RequestBody Product editedProduct) {
        Product existingProduct = productRepository.findByPrdid(prdid);
        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }

        // editedProduct의 내용으로 existingProduct를 업데이트
        existingProduct.setPrdname(editedProduct.getPrdname());
        existingProduct.setPrdprice(editedProduct.getPrdprice());
        existingProduct.setPrddes(editedProduct.getPrddes());

        // 저장 후 응답
        productRepository.save(existingProduct);
        return ResponseEntity.ok("Product with ID " + prdid + " has been updated.");
    }
}