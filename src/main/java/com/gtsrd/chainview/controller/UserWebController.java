package com.gtsrd.chainview.controller;

import com.gtsrd.chainview.dto.UserLoginDto;
import com.gtsrd.chainview.dto.UserRegistrationDto;
import com.gtsrd.chainview.model.Event;
import com.gtsrd.chainview.model.User;
import com.gtsrd.chainview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Controller
//@RequestMapping("/user")
public class UserWebController {
	@Autowired
	private UserService userService;

	@GetMapping("/user-registration")
	public String showRegistrationForm(Model model) {
		// create event object to hold event form data
		UserRegistrationDto userObj = new UserRegistrationDto();
		model.addAttribute("userObj", userObj);
		return "registration";
	}
	
	@PostMapping("/user-register")
	public String registerUserAccount(@ModelAttribute("userObj") UserRegistrationDto registrationDto, Model model) {
		User registeredUser = userService.checkIfRegisteredUser(registrationDto.getEmail());

		if(Objects.nonNull(registeredUser)){
			model.addAttribute("abortRegister",true);
			return "registration";
		}
		else {
			userService.save(registrationDto);
			return "redirect:/user-login";
		}
	}

	@GetMapping("/user-login")
	public String showLoginForm() {
		// create event object to hold event form data
		return "login";
	}

	@PostMapping("/user-login")
	public String loginUser(@ModelAttribute("userObj") UserLoginDto loginDto, Model model) {
		User loggedInUser = userService.login(loginDto.getEmail(),loginDto.getPassword());

		if(Objects.nonNull(loggedInUser)){
			return "redirect:/user-list";
		}
		else {
			model.addAttribute("abortLogin",true);
			return "login";
		}
	}

	@GetMapping("/user-list")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getActiveUsers());
		return "users";
	}

	@GetMapping("/all-user-list")
	public String listAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@GetMapping("/user-edit/{id}")
	public String editUserForm(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit_user";
	}

	@PostMapping("/user-update/{id}")
	public String updateUser(@PathVariable int id,
								@ModelAttribute("user") User user,
								Model model) {

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
		var current_timestamp = dateFormat.format(date);


		// get student from database by id
		User existingUser = userService.getUserById(id);
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		existingUser.setGender(user.getGender());
		existingUser.setDob(user.getDob());
		existingUser.setPhone(user.getPhone());
		existingUser.setLocation(user.getLocation());
		existingUser.setEmail(user.getEmail());
		existingUser.setUpdated_ts(current_timestamp);
		existingUser.setClient_id(user.getFirstname() + user.getLastname() + user.getDob().substring(2,4) + user.getDob().substring(5,7));

		// save updated student object
		userService.updateUser(existingUser);
		return "redirect:/user-list";
	}

	@GetMapping("/user-delete/{id}")
	public String deleteUser(@PathVariable int id,@ModelAttribute("user") User user) {
		User existingUser = userService.getUserById(id);
		existingUser.setStatus("Deleted");

		// save updated student object
		userService.updateUser(existingUser);
//		userService.deleteUserById(id);
		return "redirect:/user-list";
	}

}
