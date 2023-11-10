package com.example.project1_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {

    @Id
    @Column(name = "CMP_ID")
    private String cmpid;

    @Column(name = "CMP_NAME", length = 30, nullable = false)
    private String cmpname;

    @Column(name = "CMP_INFO", nullable = false)
    private String cmpinfo;

    @Column(name = "CMP_INDU", length = 15, nullable = false)
    private String cmpindu;

    @Column(name = "CMP_ADD", length = 100 , nullable = false)
    private String cmpadd;

    @Column(name = "CMP_ADDNUM", nullable = false)
    private int cmpaddnum;

    @Column(name = "CMP_ADDDETAIL", length = 100, nullable = false)
    private String cmpadddetail;

    @Column(name = "CMP_CONTACT", length = 15, nullable = false)
    private String cmpcontact;

}
