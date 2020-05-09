package com.example.restapi.services;

import com.example.restapi.dto.EmployeeDTO;
import com.example.restapi.dto.EmployeeUpdateDTO;
import com.example.restapi.entities.Employee;

import java.util.List;

public interface EmployeeService {

	public List<EmployeeDTO> findAll();

	public EmployeeDTO findById(Long id);

	public void save(Employee employee);

	public void deleteById(Long id);

	public List<EmployeeDTO> findPaginated(int page, int size);

	public EmployeeDTO update(Long id, EmployeeUpdateDTO employeeUpdateDTO);

}
