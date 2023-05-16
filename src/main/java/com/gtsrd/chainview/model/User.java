package com.gtsrd.chainview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name =  "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int user_id;
	private String client_id;
	private String firstname;
	private String lastname;
	private String display_name;
	private String gender;
	private String password;
	private String email;
	private String phone;
	private String location;
	private String dob;
	private String status;
	private String created_ts;
	private String updated_ts;
	private String notes;
	private String role;

	public User(String firstname, String lastname, String gender, String password, String email, String phone,
                String location, String dob) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.dob = dob;
	}

	public User(String firstname, String lastname, String gender, String phone,
				String location, String dob) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.phone = phone;
		this.location = location;
		this.dob = dob;
	}
}
