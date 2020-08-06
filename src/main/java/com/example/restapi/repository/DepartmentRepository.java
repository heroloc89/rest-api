package com.example.restapi.repository;

import com.example.restapi.dto.EmpDeptDTO;
import com.example.restapi.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
//    @Query("SELECT new com.example.restapi.dto.EmpDeptDTO(e.first_name, e.last_name, d.department_name) "
//            + "FROM Department d LEFT JOIN d.employees e")
//    List<EmpDeptDTO> fetchEmpDeptDataLeftJoin();
}
