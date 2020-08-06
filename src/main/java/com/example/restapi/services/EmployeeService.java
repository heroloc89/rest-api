package com.example.restapi.services;

import com.example.restapi.dto.EmpDeptDTO;
import com.example.restapi.dto.EmployeeCreateDTO;
import com.example.restapi.dto.EmployeeDTO;
import com.example.restapi.dto.EmployeeUpdateDTO;
import com.example.restapi.entities.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAll();

    EmployeeDTO findById(Long id);

    void save(Employee employee);

    void deleteById(Long id);

    List<EmployeeDTO> findPaginated(int page, int size);

    EmployeeDTO update(Long id, EmployeeUpdateDTO employeeUpdateDTO);

    void create(EmployeeCreateDTO employeeCreateDTO);

    List<EmployeeDTO> findAllByStream();

    List<EmpDeptDTO> findByDepartmentId(int departmentId);

}
