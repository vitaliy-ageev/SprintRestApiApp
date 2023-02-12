package org.ageev.springrestapi.SpringRestApiApplication.controller;

import org.ageev.springrestapi.SpringRestApiApplication.config.JwtTokenUtil;
import org.ageev.springrestapi.SpringRestApiApplication.dto.JwtRequest;
import org.ageev.springrestapi.SpringRestApiApplication.dto.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
public class AuthController {
    private final JwtTokenUtil jwtTokenUtil;
    
    public AuthController(JwtTokenUtil jwtTokenUtil) {this.jwtTokenUtil = jwtTokenUtil;}
    
    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) throws Exception {
        UserDetails userDetails = new User(authRequest.getUsername(), authRequest.getPassword(), Collections.emptyList());
        
        String token = jwtTokenUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
