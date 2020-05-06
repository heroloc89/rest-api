package com.example.restapi.controller;

import com.example.restapi.entities.Employee;
import com.example.restapi.repository.EmployeeRepository;
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
public class EmployeeApiController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employee")
	public List<Employee> getEmployeeList() {
		return this.employeeRepository.findAll();
	}

	@GetMapping("/employee/{employeeId}")
	public Optional<Employee> getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		return this.employeeRepository.findById(employeeId);
	}

	@PutMapping("/employee/{employeeId}")
	public Employee editEmployee(@PathVariable(name = "employeeId") Long employeeId, @RequestBody Employee employee) {
		Employee updatedEmployee = this.employeeRepository.getOne(employeeId);
		updatedEmployee.setFirstName(employee.getFirstName());
		updatedEmployee.setLastName(employee.getLastName());
		updatedEmployee.setBirthDate(employee.getBirthDate());
		updatedEmployee.setGender(employee.getGender());
		updatedEmployee.setAddress(employee.getAddress());
		this.employeeRepository.save(updatedEmployee);
		return employee;
	}

	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity deleteEmployee(@PathVariable(name = "employeeId") Long employeeId){
		Employee deletedEmployee = this.employeeRepository.getOne(employeeId);
		this.employeeRepository.delete(deletedEmployee);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/employee")
	public ResponseEntity addEmployee(@RequestBody Employee employee) {
		this.employeeRepository.save(employee);
		return ResponseEntity.ok().body(employee);
	}

}
