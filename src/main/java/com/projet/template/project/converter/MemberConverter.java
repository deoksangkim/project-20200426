package com.projet.template.project.converter;

import com.projet.template.project.dto.MemberDto;
import com.projet.template.project.entities.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberConverter {

    public MemberDto convert(MemberEntity entity) {
        return MemberDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .build();
    }
}
