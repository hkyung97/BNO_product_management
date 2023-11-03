package com.example.project1_back.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "PRD_ID")
    private String prdid;

    @Column(name = "PRD_NAME", length = 30, nullable = false)
    private String prdname;

    @Column(name = "PRD_PRICE", nullable = false)
    private int prdprice;

    @Column(name = "PRD_DES", nullable = false)
    private String prddes;

    @Column(name = "EMP_ID", length = 8)
    private String empid;

    @Column(name = "CMP_ID", length = 8)
    private String cmpid;

    @Column(name = "IMG_PATH", length = 100)
    private String imgpath;
}
