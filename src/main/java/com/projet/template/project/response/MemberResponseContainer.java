package com.projet.template.project.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
public class MemberResponseContainer <T> {
    private String responseCode;
    private T data;
}
