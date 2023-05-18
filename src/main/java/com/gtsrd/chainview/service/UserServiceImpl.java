package com.gtsrd.chainview.service;

import com.gtsrd.chainview.dto.UserRegistrationDto;
import com.gtsrd.chainview.model.User;
import com.gtsrd.chainview.repository.UserRepository;
import com.gtsrd.chainview.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public ApiResponse save(UserRegistrationDto registrationDto) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
		var current_timestamp = dateFormat.format(date);

		String firstname = registrationDto.getFirstname().length() > 3 ? registrationDto.getFirstname().substring(0,3) : registrationDto.getFirstname();
		String lastname = registrationDto.getLastname().length() > 3 ? registrationDto.getLastname().substring(0,3) : registrationDto.getLastname();
		String clientId = firstname + lastname + registrationDto.getDob().substring(2,4) + registrationDto.getDob().substring(5,7);
		String display_name = firstname + lastname ;


		User user = new User(registrationDto.getFirstname(),
				registrationDto.getLastname(),registrationDto.getGender(),
				registrationDto.getPassword(), registrationDto.getEmail(),
				registrationDto.getPhone(),registrationDto.getLocation(),registrationDto.getDob(),
				clientId, display_name, "Active",current_timestamp, null );

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
	public List<User> getActiveUsers() {
		List<User> userRep = userRepository.findAll();
		List<User> filteredData = new ArrayList<>();
		for(User user : userRep){
			if(user.getStatus().equals("Active")){
				filteredData.add(user);
			}
		}
		return filteredData;
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
