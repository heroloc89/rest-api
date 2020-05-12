package com.example.restapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeCreateDTO {
    @ApiModelProperty(notes = "First name of employee")
    private String firstName;

    @ApiModelProperty(notes = "Last name of employee")
    private String lastName;

    @ApiModelProperty(notes = "Birth date of employee")
    private Date birthDate;

    @ApiModelProperty(notes = "Gender of employee")
    private String gender;

    @ApiModelProperty(notes = "Address of employee")
    private String address;

}
