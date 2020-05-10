package com.example.restapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private String gender;

    private String address;

}
