package com.voenmeh.voenmehpearl.dao;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;
    private String email;
}
