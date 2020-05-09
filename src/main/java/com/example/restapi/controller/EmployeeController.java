package com.example.restapi.controller;

import com.example.restapi.dto.EmployeeUpdateDTO;
import com.example.restapi.entities.Employee;
import com.example.restapi.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping()
	public List<Employee> retrieveAllEmployees(@RequestParam(defaultValue = "0") int page,
											   @RequestParam(defaultValue = "3") int size) {
		return this.employeeService.findPaginated(page, size);
	}

	@GetMapping("/{id}")
	public Optional<Employee> retrieveEmployee(@PathVariable Long id) {
		return employeeService.findById(id);
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//		Optional<Employee> empFromDb = this.employeeService.findById(id);
//		if (empFromDb.isPresent()) {
//			employee.setId(id);
//			this.employeeService.save(employee);
//			return ResponseEntity.ok().body(employee);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
		Optional<Employee> empFromDb = this.employeeService.findById(id);
		if (empFromDb.isPresent()) {
			Employee updatedEmployee = modelMapper.map(empFromDb.get(), Employee.class);
			modelMapper.map(employeeUpdateDTO, updatedEmployee);
//			Employee employee = convertToEntity(employeeUpdateDTO);
			updatedEmployee.setId(id);
			this.employeeService.save(updatedEmployee);
			return ResponseEntity.ok().body(updatedEmployee);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deleteEmployee(@PathVariable Long id) {
		this.employeeService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping
	public ResponseEntity createEmployee(@RequestBody Employee employee) {
		this.employeeService.save(employee);
		return ResponseEntity.ok().body(employee);
	}

	private EmployeeUpdateDTO convertToDto(Employee employee) {
		return modelMapper.map(employee, EmployeeUpdateDTO.class);
	}

	private Employee convertToEntity(EmployeeUpdateDTO employeeUpdateDTO) {
		return modelMapper.map(employeeUpdateDTO, Employee.class);
	}

}
