package com.example.restapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@Data
public class EmployeeUpdateDTO {
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
}
