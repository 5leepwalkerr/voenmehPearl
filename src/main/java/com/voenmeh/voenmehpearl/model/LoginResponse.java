package com.voenmeh.voenmehpearl.model;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;
    private String email;
}
