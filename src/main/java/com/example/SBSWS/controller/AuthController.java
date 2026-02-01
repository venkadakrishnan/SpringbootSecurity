package com.example.SBSWS.controller;

import com.example.SBSWS.dto.LoginDTO;
import com.example.SBSWS.dto.RegisterDTO;
import com.example.SBSWS.entity.Employee;
import com.example.SBSWS.service.AuthService;
import com.example.SBSWS.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public Employee register(@RequestBody RegisterDTO registerDto) {
        Employee user = authService.register(registerDto);
        return user;
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO){
        Employee user = authService.authenticate(loginDTO);
        String token = jwtService.generateToken(user);
        return token;
    }
}
