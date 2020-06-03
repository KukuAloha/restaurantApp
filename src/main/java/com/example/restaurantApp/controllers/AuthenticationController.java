package com.example.restaurantApp.controllers;

import com.amazonaws.services.connect.model.UserNotFoundException;
import com.example.restaurantApp.domain.User;
import com.example.restaurantApp.dto.AuthenticationRequestDto;
import com.example.restaurantApp.security.jwt.JwtTokenProvider;
import com.example.restaurantApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth/")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getLogin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUserName(username);

            if(user == null) {
                throw new UserNotFoundException("User with username: " + username + " not found");
            }

            int id = user.getId();

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>();

            response.put("username", username);
            response.put("token", token);
            response.put("id", id);
         //   response.put("role", user.getRoles());

            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            return (ResponseEntity) ResponseEntity.status(401);
        }
    }
}
