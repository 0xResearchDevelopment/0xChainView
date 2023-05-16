package com.gtsrd.chainview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {
	private String firstname;
	private String lastname;
	private String gender;
	private String password;
	private String email;
	private String phone;
	private String location;
	private String dob;
}
