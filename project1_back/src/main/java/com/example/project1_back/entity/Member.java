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
@Table(name = "member")
public class Member {

    @Id
    @Column(name = "MEMBER_ID")
    private String memberid;

    @Column(name = "MEMBER_PASSWORD", length = 8, nullable = false)
    private String memberpassword;

    @Column(name = "MEMBER_NAME", length = 8, nullable = false)
    private String membername;

    @Column(name = "MEMBER_ADDNUM", nullable = false)
    private int memberaddnum;

    @Column(name = "MEMBER_ADD", length = 100, nullable = false)
    private String memberadd;

    @Column(name = "MEMBER_ADDDETAIL", length = 100, nullable = false)
    private String memberadddetail;

    @Column(name = "MEMBER_CONTACT", length = 15, nullable = false)
    private String membercontact;

    @Column(name = "MEMBER_GENDER", length = 8, nullable = false)
    private String membergender;

    @Column(name = "MEMBER_EMAIL", length = 8, nullable = false)
    private String memberemail;
}