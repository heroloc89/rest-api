package com.example.restapi.controller;

import com.example.restapi.entities.Employee;
import com.example.restapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> retrieveAllEmployees() {
		return this.employeeService.findAll();
	}

	@GetMapping("/employee/{id}")
	public Optional<Employee> retrieveEmployee(@PathVariable Long id) {
		return employeeService.findById(id);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		Optional<Employee> empFromDb = this.employeeService.findById(id);
		if (empFromDb.isPresent()) {
			employee.setId(id);
			this.employeeService.save(employee);
			return ResponseEntity.ok().body(employee);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity deleteEmployee(@PathVariable Long id) {
		this.employeeService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/employee")
	public ResponseEntity createEmployee(@RequestBody Employee employee) {
		this.employeeService.save(employee);
		return ResponseEntity.ok().body(employee);
	}

}
