package com.example.pjdemo.controller;

import com.example.pjdemo.dto.MemberDTO;
import com.example.pjdemo.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@Log4j2
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member")
    @Operation(summary = "이름으로 멤버 조회", description="쿼리스트링 혹은 Param으로 조회하려는 사람의 이름 입력")
    public MemberDTO getMapping(@RequestParam String name){
        log.info(name);
        MemberDTO memberDTO = memberService.getMemberDataByName(name);
        return memberDTO;
    }
    @PostMapping("/member")
    @Operation(summary = "멤버 레코드 추가", description="클라이언트 측이 Http Body로 데이터 송신")
    public MemberDTO postMapping(@RequestBody MemberDTO body){
        MemberDTO memberDTO = memberService.postMemberData(body);
        return memberDTO;
    }
    @PutMapping("/member")
    @Operation(summary = "멤버 레코드 수정", description = "클라이언트 측이 Http Body로, 수정하고 싶은 데이터만 선별적으로 송신")
    public MemberDTO putMapping(@RequestBody MemberDTO body){
        MemberDTO memberDTO = memberService.putMemberData(body);
        return memberDTO;
    }

    @DeleteMapping("/member")
    @Operation(summary = "멤버 레코드 삭제", description = "클라이언트 측이 삭제할 멤버의 데이터 ID 혹은 정보 송신")
    public void deleteMapping(@RequestParam String name){
        memberService.deleteMemberData(name);
    }
}
