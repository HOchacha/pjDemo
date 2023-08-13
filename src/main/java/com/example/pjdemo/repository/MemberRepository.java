package com.example.pjdemo.repository;

import com.example.pjdemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findById(Integer id);
    Optional<Member> findMemberByName(String name);
    Optional<Member> findAllByPlan(String plan);
}
