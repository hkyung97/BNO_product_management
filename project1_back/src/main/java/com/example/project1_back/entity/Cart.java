package com.example.project1_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_NO")
    private int cartno;

    @Column(name = "MEMBER_ID", length = 8, nullable = false)
    private String memberid;

    @Column(name = "PRD_ID", length = 8, nullable = false)
    private String prdid;


}
