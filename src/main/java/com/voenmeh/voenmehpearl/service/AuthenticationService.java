package com.voenmeh.voenmehpearl.service;

import com.voenmeh.voenmehpearl.dao.request.SignInRequest;
import com.voenmeh.voenmehpearl.dao.request.SignUpRequest;
import com.voenmeh.voenmehpearl.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(SignUpRequest request);
    JwtAuthenticationResponse signIn(SignInRequest request);
}
