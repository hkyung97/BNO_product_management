package com.example.project1_back.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "PAYMENT_NO")
    private int paymentno;

    @Column(name = "MEMBER_ID", length = 8)
    private String memberid;

    @Column(name = "CART_NO")
    private int cartno;

    @Column(name = "PRD_ID", length = 8)
    private String prdid;

    @Column(name = "PAYMENT_DATE")
    private Date paymentdate;

}
