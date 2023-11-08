package com.example.project1_back.controller;

import com.example.project1_back.entity.Member;
import com.example.project1_back.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/api/member/login")
    public String login(@RequestBody Map<String, String> params,
                        HttpServletResponse res) { //@RequestBody요청일 때의 json 규칙 Map<String, String>
        Member member = memberRepository.findByMemberidAndMemberpassword(params.get("memberid"), params.get("memberpassword"));
        System.out.println(member);
        if (member != null) {
            return member.getMemberid();
        }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/api/member/add")
    public ResponseEntity<String> addMember(@RequestBody Member member) {
        try {
            Member savedMember =  memberRepository.save(member);
            return ResponseEntity.ok("회원가입이 완료 되었습니다. 구매자권한으로 이용이 가능합니다." + savedMember.getMemberid());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving Member");
        }
    }

    @GetMapping("/api/product/{prdid}")
    public ResponseEntity<Member> getCurrentUser(@PathVariable("prdid") HttpServletRequest request) {
        // 세션에서 현재 사용자 정보 가져오기
        HttpSession session = request.getSession();
        Member currentMember = (Member) session.getAttribute("currentMember");

        if (currentMember != null) {
            return ResponseEntity.ok(currentMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

