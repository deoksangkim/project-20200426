package com.projet.template.project.controller;

import com.projet.template.project.dto.ResponseCode;
import com.projet.template.project.response.MemberResponseContainer;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @ExceptionHandler(RuntimeException.class)
    public MemberResponseContainer<String> exceptionHandleController(Exception ex) {

        return MemberResponseContainer.of(ResponseCode.ERROR.name(), ex.getMessage());
    }
}
