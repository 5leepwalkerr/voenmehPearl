package com.voenmeh.voenmehpearl.service.Impl;

import com.voenmeh.voenmehpearl.dao.request.SignInRequest;
import com.voenmeh.voenmehpearl.dao.request.SignUpRequest;
import com.voenmeh.voenmehpearl.dao.response.JwtAuthenticationResponse;
import com.voenmeh.voenmehpearl.model.VoenmehRole;
import com.voenmeh.voenmehpearl.model.VoenmehUser;
import com.voenmeh.voenmehpearl.repository.VoenmehUserRepository;
import com.voenmeh.voenmehpearl.service.AuthenticationService;
import com.voenmeh.voenmehpearl.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private VoenmehUserRepository voenmehUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        var user = VoenmehUser.builder()
                .email(request.getEmail())
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .userRole(VoenmehRole.USER)
                .creationDateTime(new Date())
                .build();
        voenmehUserRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse
                .builder()
                .token(jwt)
                .build();
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        var user = voenmehUserRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
