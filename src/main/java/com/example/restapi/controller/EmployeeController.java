package com.example.restapi.controller;

import com.example.restapi.dto.EmployeeCreateDTO;
import com.example.restapi.dto.EmployeeDTO;
import com.example.restapi.dto.EmployeeUpdateDTO;
import com.example.restapi.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	@ApiOperation(value = "Retrieve a list of employees", response = EmployeeDTO.class)
	@GetMapping(produces = "application/json")
	@ResponseBody
	public List<EmployeeDTO> retrieveAllEmployees(@RequestParam(defaultValue = "0") int page,
												  @RequestParam(defaultValue = "3") int size) {
		return this.employeeService.findPaginated(page, size);
	}

	@ApiOperation(value = "Retrieve an employee with an ID", response = EmployeeDTO.class)
	@GetMapping("/{id}")
	@ResponseBody
	public EmployeeDTO retrieveEmployee(@PathVariable Long id) {
		return employeeService.findById(id);
	}

	@ApiOperation(value = "Update an employee", response = EmployeeDTO.class)
	@PutMapping("/{id}")
	public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
		return this.employeeService.update(id, employeeUpdateDTO);
	}

	@ApiOperation(value = "Delete an employee")
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		this.employeeService.deleteById(id);
	}

	@ApiOperation(value = "Create an employee")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void createEmployee(@RequestBody EmployeeCreateDTO employeeCreateDTO) {
		this.employeeService.create(employeeCreateDTO);
	}
}
