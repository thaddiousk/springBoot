package com.example.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {
	
	@JsonProperty("first_name")
	@NotBlank(message = "First name is required.")
	private String firstName;
	
	@NotBlank(message = "Last name is required.")
	private String lastName;
	
	@NotBlank(message = "Email is required.")
	private String email;

}
