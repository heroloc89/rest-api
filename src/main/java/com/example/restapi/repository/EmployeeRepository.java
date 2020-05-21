package com.example.restapi.repository;

import com.example.restapi.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.stream.Stream;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    @Query("select e from Employee e")
    Stream<Employee> findAllEmployees();
}
