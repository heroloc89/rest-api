package com.example.restapi.controller;

import com.example.restapi.dto.EmployeeDTO;
import com.example.restapi.dto.EmployeeUpdateDTO;
import com.example.restapi.entities.Employee;
import com.example.restapi.services.EmployeeService;
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

	@GetMapping()
	@ResponseBody
	public List<EmployeeDTO> retrieveAllEmployees(@RequestParam(defaultValue = "0") int page,
											   @RequestParam(defaultValue = "3") int size) {
		return this.employeeService.findPaginated(page, size);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public EmployeeDTO retrieveEmployee(@PathVariable Long id) {
		return employeeService.findById(id);
	}


	@PutMapping("/{id}")
	public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeUpdateDTO employeeUpdateDTO) {
		return this.employeeService.update(id, employeeUpdateDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		this.employeeService.deleteById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void createEmployee(@RequestBody Employee employee) {
		this.employeeService.save(employee);
	}

}
