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
@Table(name = "manager")
public class Manager {

    @Id
    @Column(name = "EMP_ID")
    private String empid;

    @Column(name = "EMP_NAME", length = 8, nullable = false)
    private String empname;

    @Column(name = "DEP_NAME", length = 10, nullable = false)
    private String depname;

    @Column(name = "CMP_ID", length = 8, nullable = false)
    private String cmpid;

    @Column(name = "EMP_ADDNUM", nullable = false)
    private int empaddnum;

    @Column(name = "EMP_ADD", length = 100, nullable = false)
    private String empadd;

    @Column(name = "EMP_ADDDETAIL", length = 100, nullable = false)
    private String empadddetail;

    @Column(name = "EMP_CONTACT", length = 15, nullable = false)
    private String empcontact;

    @Column(name = "EMP_POS", length = 8, nullable = false)
    private String emppos;
}
