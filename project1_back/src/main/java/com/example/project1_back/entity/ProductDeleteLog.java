package com.example.project1_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "productdeletelog")
public class ProductDeleteLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRD_DELETE_LOG_NO")
    private int prddeletelogno;

    @Column(name = "PRD_ID", length = 8, nullable = false)
    public String prdid;

    @Column(name = "EMP_ID",length = 8, nullable = false)
    public String empid;

    @Column(name = "ACTIVITY_TIMESTAMP", nullable = false)
    private LocalDateTime activitytime;


}
