package com.github.fr3d3rico.backendrealappcase.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fr3d3rico.backendrealappcase.model.JwtTokenProvider;
import com.github.fr3d3rico.backendrealappcase.model.User;
import com.github.fr3d3rico.backendrealappcase.repository.UserRepository;
import com.github.fr3d3rico.backendrealappcase.services.CustomUserDetailsService;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/auth", produces = "application/json")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @Autowired
    private CustomUserDetailsService userService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthBody data) throws JsonProcessingException {
    	Map<Object, Object> model = new HashMap<>();
        try {
            String email = data.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, data.getPassword()));
            String token = jwtTokenProvider.createToken(email, this.users.findByEmail(email).getRoles());
            model.put("email", email);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
        	model.put("message", "Invalid email/password supplied");
        	model.put("status", HttpStatus.UNAUTHORIZED.value());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(model);
        }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
    	Map<Object, Object> model = new HashMap<>();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
        	model.put("message", "User with email: " + user.getEmail() + " already exists");
            model.put("status", HttpStatus.CONFLICT.value());
        	return ResponseEntity.status(HttpStatus.CONFLICT).body(model);
        }
        userService.saveUser(user);
        model.put("message", "User registered successfully");
        model.put("status", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }
}