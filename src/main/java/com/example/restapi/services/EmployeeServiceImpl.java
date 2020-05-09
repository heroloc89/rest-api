package com.example.restapi.services;

import com.example.restapi.dto.EmployeeDTO;
import com.example.restapi.dto.EmployeeUpdateDTO;
import com.example.restapi.entities.Employee;
import com.example.restapi.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ModelMapper modelMapper;

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

	@Override
	public EmployeeDTO update(Long id, EmployeeUpdateDTO employeeUpdateDTO) {
		Optional<Employee> empFromDb = this.findById(id);
		Employee updatedEmployee = modelMapper.map(empFromDb.get(), Employee.class);
		modelMapper.map(employeeUpdateDTO, updatedEmployee);
		updatedEmployee.setId(id);
		this.save(updatedEmployee);
		return modelMapper.map(updatedEmployee, EmployeeDTO.class);
	}
}
