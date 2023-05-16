package com.gtsrd.chainview.service;


import com.gtsrd.chainview.dto.UserRegistrationDto;
import com.gtsrd.chainview.model.User;
import com.gtsrd.chainview.response.ApiResponse;

import java.util.List;

public interface UserService {
	ApiResponse save(UserRegistrationDto registrationDto);

	User login(String email, String password);

	User checkIfRegisteredUser(String email);

	List<User> getAllUsers();

	User getUserById(int id);

	ApiResponse updateUser(User user);

	String deleteUserById(int id);
}
