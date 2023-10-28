package com.voenmeh.voenmehpearl.service.Impl;

import com.voenmeh.voenmehpearl.dao.request.SignInRequest;
import com.voenmeh.voenmehpearl.dao.request.SignUpRequest;
import com.voenmeh.voenmehpearl.dao.response.JwtAuthenticationResponse;
import com.voenmeh.voenmehpearl.model.VoenmehRole;
import com.voenmeh.voenmehpearl.model.VoenmehUser;
import com.voenmeh.voenmehpearl.repository.VoenmehUserRepository;
import com.voenmeh.voenmehpearl.service.AuthenticationService;
import com.voenmeh.voenmehpearl.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
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
        VoenmehUser  user = new VoenmehUser();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCreationDateTime(new Date());
        user.setUserRole(VoenmehRole.USER);
        // геттер username выдает почту почему-то
        voenmehUserRepository.save(user);
        log.info("New user - {}",user.getEmail());
        log.info("New user - {}",user.getPassword());
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse
                .builder()
                .token(jwt)
                .build();
    }

    @Override
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        var user = voenmehUserRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        log.info("New user - {}",user.getUsername());
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse
                .builder()
                .token(jwt)
                .build();
    }
}
