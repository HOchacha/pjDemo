package com.example.pjdemo.service;

import com.example.pjdemo.dto.MemberDTO;
import com.example.pjdemo.entity.Member;
import com.example.pjdemo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.antlr.v4.runtime.misc.TestRig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
@Log4j2
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDTO postMemberData(MemberDTO memberDTO) {
        log.info(memberDTO);
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
    public MemberDTO putMemberData(MemberDTO body) {
        Optional<Member> result = memberRepository.findMemberByName(body.getName());
        if(result.isPresent()) {
            Member entity = result.get();
            Member updatedEntity = entity.builder().name(body.getName()).gender(body.getGender()).major(body.getMajor()).age(body.getAge()).plan(body.getPlan()).build();
            memberRepository.save(updatedEntity);
            return getMemberDataByName(body.getName());
        }else {
            return null;
        }

    }
    public void deleteMemberData(String name) {
        Optional<Member> result = memberRepository.findMemberByName(name);
        if(result.isPresent()) {
            memberRepository.delete(result.get());
        }
    }
    private MemberDTO convertToDTO(Member member) {
        return new MemberDTO(member.getName(), member.getGender(), member.getAge(), member.getMajor(), member.getPlan());
    }



}