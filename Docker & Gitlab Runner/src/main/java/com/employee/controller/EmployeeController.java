package com.employee.controller;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getAll(){
		return ResponseEntity.ok(employeeservice.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findById(@PathVariable Long id){
		return ResponseEntity.ok(employeeservice.findById(id).orElse(null));
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addAll(@RequestBody Employee emp){
		return ResponseEntity.ok(employeeservice.save(emp));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody Employee emp){
		return ResponseEntity.ok(employeeservice.save(emp));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Employee> delete(@PathVariable Long id){
		employeeservice.findById(id).ifPresent(employeeservice::delete);
		return ResponseEntity.ok().build();
	}

}
