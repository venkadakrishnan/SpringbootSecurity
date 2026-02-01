package com.example.SBSWS.repository;

import com.example.SBSWS.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface EmployeeRepository extends JpaRepository<Employee, Long>{
               Employee findByEmail(String email);
    }

