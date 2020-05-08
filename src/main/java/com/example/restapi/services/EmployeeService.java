package com.example.restapi.services;

import com.example.restapi.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

	public List<Employee> findAll();

	public Optional<Employee> findById(Long id);

	public void save(Employee employee);

	public void deleteById(Long id);

	public List<Employee> findPaginated(int page, int size);

}
