package com.example.restapi.services;

import com.example.restapi.dto.EmployeeCreateDTO;
import com.example.restapi.dto.EmployeeDTO;
import com.example.restapi.dto.EmployeeUpdateDTO;
import com.example.restapi.entities.Employee;
import com.example.restapi.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        return employees.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found employee id " + id));
        return convertToDto(employee);
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
    public List<EmployeeDTO> findPaginated(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Employee> pagedResult = employeeRepository.findAll(paging);
        return pagedResult.toList().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO update(Long id, EmployeeUpdateDTO employeeUpdateDTO) {
        EmployeeDTO empFromDb = this.findById(id);
        Employee updatedEmployee = modelMapper.map(empFromDb, Employee.class);
        modelMapper.map(employeeUpdateDTO, updatedEmployee);
        updatedEmployee.setId(id);
        this.save(updatedEmployee);
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
    }

    @Override
    public void create(EmployeeCreateDTO employeeCreateDTO) {
        Employee employee = modelMapper.map(employeeCreateDTO, Employee.class);
        this.save(employee);
    }

    private EmployeeDTO convertToDto(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
}
