package com.example.SBSWS.service;

import com.example.SBSWS.dto.LoginDTO;
import com.example.SBSWS.dto.RegisterDTO;
import com.example.SBSWS.entity.Employee;
import com.example.SBSWS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private EmployeeRepository repo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public Employee register(RegisterDTO input){
        Employee user = new Employee();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(input.getRole());
        repo.save(user);
        return user;
    }
    public  Employee authenticate(LoginDTO input){
        authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword())
        );
         return repo.findByEmail(input.getEmail());
    }
}
