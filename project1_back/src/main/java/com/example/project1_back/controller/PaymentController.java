package com.example.project1_back.controller;

import com.example.project1_back.entity.Payment;
import com.example.project1_back.entity.Product;
import com.example.project1_back.repository.MemberRepository;
import com.example.project1_back.repository.PaymentRepository;
import com.example.project1_back.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;
    MemberRepository memberRepository;

//    @GetMapping("/api/products")
//    public List<Product> getProducts() { //entity에 있는 Product(dto개념)가 여기서의 Product
//        List<Product> products = productRepository.findAll();
//        return products;
//    }




    @PostMapping("/api/products/payment/{prdid}")
    public ResponseEntity<String> PaymentInfo(@PathVariable("prdid") @RequestBody Payment payment) {
        try {
            Payment PaymentInfo = paymentRepository.save(payment);
            return ResponseEntity.ok("Product saved with ID: " + PaymentInfo.getPrdid());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving product");
        }
    }

//    @GetMapping("/api/products/{prdid}")
//    public ResponseEntity<Product> getOneProduct(@PathVariable("prdid") String prdid) {
//        System.out.println(prdid);
//
//        Product product = productRepository.findByPrdid(prdid);
////        System.out.println(product);
//        if (product != null) {
//            return ResponseEntity.ok(product);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @DeleteMapping ("/api/products/{prdid}")
//    public ResponseEntity<String> deleteProductById(@PathVariable("prdid") String prdid) {
//        try {
//            productRepository.deleteById(prdid);
//            return ResponseEntity.ok(prdid + " 가 삭제 되었습니다.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting product");
//        }
//    }

//    @PutMapping("/api/products/{prdid}")
//    public ResponseEntity<String> editProduct(@PathVariable String prdid, @RequestBody Product editedProduct) {
//        Product existingProduct = productRepository.findByPrdid(prdid);
//        if (existingProduct == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        // editedProduct의 내용으로 existingProduct를 업데이트
//        existingProduct.setPrdname(editedProduct.getPrdname());
//        existingProduct.setPrdprice(editedProduct.getPrdprice());
//        existingProduct.setPrddes(editedProduct.getPrddes());
//
//        // 저장 후 응답
//        productRepository.save(existingProduct);
//        return ResponseEntity.ok("Product with ID " + prdid + " has been updated.");
//    }
}