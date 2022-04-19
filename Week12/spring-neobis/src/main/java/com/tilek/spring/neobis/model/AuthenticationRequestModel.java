package com.tilek.spring.neobis.model;

import lombok.Data;

@Data
public class AuthenticationRequestModel {
    private String email;
    private String password;
}
