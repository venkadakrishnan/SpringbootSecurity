package com.example.SBSWS.controller;

import com.example.SBSWS.entity.Employee;
import com.example.SBSWS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/employees")
    public String getEmployess(){
        return "List of Tech Ampliefier's Employess";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/home")
    public String getHome(){
        return "Welcome to Home Screen";
    }

    @GetMapping("/employees/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }
}
