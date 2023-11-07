package com.example.project1_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @Column(name = "MEMBER_ID")
    private String memberid;

    @Column(name = "PRD_ID", length = 100, nullable = false)
    private String prdid;


}
