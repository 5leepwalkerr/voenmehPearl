package com.voenmeh.voenmehpearl.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Value("${jwt.secret.key}")
    private String privateKey;

    private final long accessTokenValidity = 60*60*10;

    private final String JWT_HEADER = "Authorization";
    private final String JWT_TOKEN_PREFIX = "Bearer ";

}
