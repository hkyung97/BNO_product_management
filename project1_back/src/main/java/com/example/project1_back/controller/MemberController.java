package com.example.project1_back.controller;

import com.example.project1_back.entity.Member;
import com.example.project1_back.repository.MemberRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
}

