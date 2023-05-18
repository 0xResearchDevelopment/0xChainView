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

	public User(String firstname, String lastname, String gender, String password, String email, String phone,
                String location, String dob, String client_id,  String display_name, String status, String created_ts, String updated_ts) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.dob = dob;
		this.client_id = client_id;
		this.display_name = display_name;
		this.status = status;
		this.created_ts = created_ts;
		this.updated_ts = updated_ts;
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
