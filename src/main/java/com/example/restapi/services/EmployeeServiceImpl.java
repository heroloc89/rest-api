package com.example.restapi.services;

import com.example.restapi.entities.Employee;
import com.example.restapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findPaginated(int page, int size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Employee> pagedResult = employeeRepository.findAll(paging);
		return pagedResult.toList();
	}
}
