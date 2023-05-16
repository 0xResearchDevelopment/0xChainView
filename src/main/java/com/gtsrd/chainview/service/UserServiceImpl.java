package com.gtsrd.chainview.service;

import com.gtsrd.chainview.dto.UserRegistrationDto;
import com.gtsrd.chainview.model.User;
import com.gtsrd.chainview.repository.UserRepository;
import com.gtsrd.chainview.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public ApiResponse save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getFirstname(),
				registrationDto.getLastname(),registrationDto.getGender(),
				registrationDto.getPassword(), registrationDto.getEmail(),
				registrationDto.getPhone(),registrationDto.getLocation(),registrationDto.getDob());

		userRepository.save(user);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("User Registered successfully!");
		return apiResponse;
	}

	@Override
	public User login(String email, String password) {
		User user = userRepository.findByEmailAndPassword(email, password);
		return user;
	}

	@Override
	public User checkIfRegisteredUser(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public ApiResponse updateUser(User user) {
	/*	User updatedUser = new User(user.getFirstname(),
				user.getLastname(),user.getGender(), user.getPhone(),
				user.getLocation(),user.getDob());
		userRepository.save(updatedUser);*/
		userRepository.save(user);
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("User Updated successfully!");
		return apiResponse;
	}

	@Override
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "User deleted !! " + id;
	}

}
