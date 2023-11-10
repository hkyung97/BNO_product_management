package com.example.project1_back.repository;

import com.example.project1_back.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByMemberid(String memberid); //cartno를 인자로 모든 cart정보 가져오기
    Cart findByMemberidAndPrdid(String memberid, String prdid); //memberid, prdid로 cart 정보 가져오기



}



