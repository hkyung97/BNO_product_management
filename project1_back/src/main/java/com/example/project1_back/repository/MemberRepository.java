package com.example.project1_back.repository;

import com.example.project1_back.entity.Manager;
import com.example.project1_back.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByMemberidAndMemberpassword(String memberid, String memberpassword);

    Member save(Member member);


}

