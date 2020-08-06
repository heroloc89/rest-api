package com.example.restapi.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
