package com.example.project1_back.controller;

import com.example.project1_back.entity.Cart;
import com.example.project1_back.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @GetMapping("/api/cart/products")
    public ResponseEntity getCartProducts(@RequestParam String memberid) {
        List<Cart> carts = cartRepository.findByMemberid(memberid);

        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    @PostMapping("/api/cart/products/{prdid}")
    public ResponseEntity pushCartProduct(
            @RequestParam String memberid,
            @PathVariable String prdid
    ) {
        try {
            Cart cart = cartRepository.findByMemberidAndPrdid(memberid, prdid);
            if (cart == null) {
                Cart newCart = new Cart();
                newCart.setMemberid(memberid);
                newCart.setPrdid(prdid);
                cartRepository.save(newCart);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
