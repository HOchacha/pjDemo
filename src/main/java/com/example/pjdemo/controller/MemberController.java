package com.example.pjdemo.controller;

import com.example.pjdemo.dto.MemberDTO;
import com.example.pjdemo.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = {"Food"})
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member")
    @ApiOperation(value = "이름으로 멤버 조회", notes="쿼리스트링 혹은 Param으로 조회하려는 사람의 이름 입력")
    public MemberDTO test(@RequestParam String name){
        log.info(name);
        MemberDTO memberDTO = memberService.getMemberDataByName(name);
        return memberDTO;
    }
    @PostMapping("/member")
    @ApiOperation(value = "멤버 레코드 추가", notes="클라이언트 측이 Http Body로 데이터 송신")
    public MemberDTO test(@RequestBody MemberDTO body){
        MemberDTO memberDTO = memberService.postMemberData(body);
        return memberDTO;
    }
}
