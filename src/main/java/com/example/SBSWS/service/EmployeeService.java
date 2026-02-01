package com.example.SBSWS.service;

import com.example.SBSWS.entity.Employee;
import com.example.SBSWS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;
    //get All Employees
    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }
}
