package com.example.project1_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "productlog")
public class ProductEditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_NO")
    private int logno;

    @Column(name = "PRD_ID", length = 8, nullable = false)
    private String prdid;

    @Column(name = "EMP_ID",length = 8, nullable = false)
    private String empid;

    @Column(name = "ACTIVITY_TIMESTAMP", nullable = false)
    private LocalDateTime activitytime;

    @Column(name = "ACTIVITY_TYPE", length = 8, nullable = false)
    private String activitytipe;

}
