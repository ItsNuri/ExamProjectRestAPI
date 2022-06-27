package com.example.examprojectrestapi.dto;

import com.example.examprojectrestapi.models.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    private String email;

    private String password;

}

