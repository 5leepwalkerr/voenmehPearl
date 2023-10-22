package com.voenmeh.voenmehpearl.controller;

import com.voenmeh.voenmehpearl.dao.request.SignInRequest;
import com.voenmeh.voenmehpearl.dao.request.SignUpRequest;
import com.voenmeh.voenmehpearl.dao.response.JwtAuthenticationResponse;
import com.voenmeh.voenmehpearl.service.AuthenticationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pearl/auth")
public class AuthController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request){
        return ResponseEntity.ok(authenticationService.signUp(request));
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInRequest request){
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}
