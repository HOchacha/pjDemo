package com.example.pjdemo.service;

import com.example.pjdemo.dto.MemberDTO;
import com.example.pjdemo.entity.Member;
import com.example.pjdemo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.TestRig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDTO postMemberData(MemberDTO memberDTO) {
        memberRepository.save(new Member(memberDTO.getName(), memberDTO.getGender(), memberDTO.getAge(), memberDTO.getMajor(), memberDTO.getPlan()));
        Optional<Member> result = memberRepository.findMemberByName(memberDTO.getName());
        if (result.isPresent()) {
            return convertToDTO(result.get());
        }
        else {
            return null;
        }
    }

    public MemberDTO getMemberDataByName(String name){
        Optional<Member> result = memberRepository.findMemberByName(name);
        if (result.isPresent()) {
            return convertToDTO(result.get());
        }
        else {
            return null;
        }
    }
    private MemberDTO convertToDTO(Member member) {
        return new MemberDTO(member.getNum(), member.getName(), member.getGender(), member.getAge(), member.getMajor(), member.getPlan());
    }
}