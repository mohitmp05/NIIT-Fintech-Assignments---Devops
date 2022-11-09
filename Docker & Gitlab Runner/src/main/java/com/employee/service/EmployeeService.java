package com.employee.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Employee;

public interface EmployeeService extends JpaRepository<Employee,Long>{

}
