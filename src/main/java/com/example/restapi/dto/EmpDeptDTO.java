package com.example.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class EmpDeptDTO {
    private String firstName;

    private String lastName;

//    @ApiModelProperty(notes = "Birth date of employee")
//    private Date birthDate;
//
//    @ApiModelProperty(notes = "Gender of employee")
//    private String gender;
//
//    @ApiModelProperty(notes = "Address of employee")
//    private String address;

    private String departmentName;



}
