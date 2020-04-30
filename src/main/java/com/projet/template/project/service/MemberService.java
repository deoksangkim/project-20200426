package com.projet.template.project.service;

import com.projet.template.project.converter.MemberConverter;
import com.projet.template.project.dto.MemberDto;
import com.projet.template.project.entities.MemberEntity;
import com.projet.template.project.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberConverter memberConverter;

    public MemberDto getMemberById(Long memberId) {
       Optional<MemberEntity> memberEntity = memberRepository.findById(memberId);
        return memberEntity.map(entity -> memberConverter.convert(entity)).orElse(null);
    }

    public String removeMember(long memberId) {
       try {
           memberRepository.deleteById(memberId);
       } catch (Exception ex) {
           log.error("failed to delete memberinfo from DB :", ex);
           return "failed";
       }
       return "success";
    }

    public List<MemberDto> getAllMembers() {
        List<MemberEntity> memberEntities = memberRepository.findAll();

        if (CollectionUtils.isEmpty(memberEntities)) {
            return Collections.emptyList();
        }
        return memberEntities.stream().map(R -> memberConverter.convert(R)).collect(Collectors.toList());
    }

    public MemberDto saveMember(MemberDto memberDto) {
        MemberEntity entity = new MemberEntity();
        entity.setName(memberDto.getName());
        entity.setEmail(memberDto.getEmail());

        try {
            memberRepository.save(entity);
        } catch (Exception ex) {
            log.error("failed to save memberEntity from DB :", ex);
            return null;
        }

        return memberDto;
    }
}
