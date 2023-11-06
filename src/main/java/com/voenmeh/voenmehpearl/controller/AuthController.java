package com.voenmeh.voenmehpearl.controller;

import com.voenmeh.voenmehpearl.dao.request.SignInRequest;
import com.voenmeh.voenmehpearl.dao.request.SignUpRequest;
import com.voenmeh.voenmehpearl.dao.request.TokenRefreshRequest;
import com.voenmeh.voenmehpearl.dao.response.JwtAuthenticationResponse;
import com.voenmeh.voenmehpearl.dao.response.TokenResponse;
import com.voenmeh.voenmehpearl.exception.ErrorResponse;
import com.voenmeh.voenmehpearl.model.VoenmehUser;
import com.voenmeh.voenmehpearl.repository.VoenmehUserRepository;
import com.voenmeh.voenmehpearl.service.AuthenticationService;
import com.voenmeh.voenmehpearl.service.JwtService;
import com.voenmeh.voenmehpearl.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pearl/auth")
public class AuthController {
    @Autowired
    private VoenmehUserRepository repository;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authenticationService.signUp(request));
    }
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request){
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
    @PostMapping("/refresh")
    public ResponseEntity<?> refreshUserAccessToken(@RequestBody TokenRefreshRequest request){
        try {
            String username = jwtService.extractUserName(request.getRefreshToken());
            UserDetails userDetails = userService
                    .userDetailsService()
                    .loadUserByUsername(username);
            String refreshTokenAccess = jwtService.generateToken(userDetails);
            return ResponseEntity.ok(new TokenResponse(refreshTokenAccess));
        }catch (Exception e){
            e.getMessage();
        }
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse("Invalid refresh token"));
    }
}
