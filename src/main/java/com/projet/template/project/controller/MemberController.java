package com.projet.template.project.controller;

import com.projet.template.project.dto.MemberDto;
import com.projet.template.project.dto.ResponseCode;
import com.projet.template.project.response.MemberResponseContainer;
import com.projet.template.project.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/app/v1")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/get/member")
    public MemberResponseContainer<MemberDto> getMemberById(@RequestParam long memberId) {
        return MemberResponseContainer.of(ResponseCode.SUCCESS.name(), memberService.getMemberById(memberId));
    }

    @RequestMapping("/save/member")
    public MemberResponseContainer<MemberDto> saveMember(@RequestBody MemberDto memberDto) {
        return MemberResponseContainer.of(ResponseCode.SUCCESS.name(), memberService.saveMember(memberDto));
    }

    @RequestMapping("/delete/member")
    public MemberResponseContainer<Boolean> deleteMemberById(@RequestParam long memberId) {
         memberService.removeMember(memberId);
         return MemberResponseContainer.of(ResponseCode.SUCCESS.name(), true);
    }

    @RequestMapping("/get/member/all")
    public MemberResponseContainer<List<MemberDto>> getMemberById() {
        return MemberResponseContainer.of(ResponseCode.SUCCESS.name(), memberService.getAllMembers());
    }
}
