package com.example.restapi.repository;

import com.example.restapi.dto.EmpDeptDTO;
import com.example.restapi.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    String query = "SELECT NEW com.example.restapi.dto.EmpDeptDTO(e.firstName, e.lastName, d.departmentName)\n" +
            " FROM Employee e INNER JOIN Department d ON d.id = e.departmentId WHERE d.id = :id";

    @Query("select e from Employee e")
    Stream<Employee> findAllEmployees();

    @Query(value = query)
    List<EmpDeptDTO> findByDepartmentId(@Param("id") int id);

    @Query(value = "SELECT e.first_name, e.last_name, d.department_name FROM Employee e INNER JOIN department d ON d.id = e.department_id", nativeQuery = true)
    Stream<String[]> findAllEmpDept();
}
