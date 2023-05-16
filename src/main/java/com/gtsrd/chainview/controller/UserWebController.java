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

import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserWebController {
	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String showRegistrationForm(Model model) {
		// create event object to hold event form data
		UserRegistrationDto userObj = new UserRegistrationDto();
		model.addAttribute("userObj", userObj);
		return "registration";
	}
	
	@PostMapping("/register")
	public String registerUserAccount(@ModelAttribute("userObj") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/user/login";
	}

	@GetMapping("/login")
	public String showLoginForm() {
		// create event object to hold event form data
		return "login";
	}

	@PostMapping("/login")
	public String loginUser(@ModelAttribute("userObj") UserLoginDto loginDto) {
		User loggedInUser = userService.login(loginDto.getEmail(),loginDto.getPassword());

		if(Objects.nonNull(loggedInUser)){
			return "redirect:/user/list";
		}
		else {
			return "redirect:/user/login";
		}
	}

	@GetMapping("/list")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@GetMapping("/edit/{id}")
	public String editUserForm(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit_user";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable int id,
								@ModelAttribute("user") User user,
								Model model) {

		// get student from database by id
		User existingUser = userService.getUserById(id);
		existingUser.setFirstname(user.getFirstname());
		existingUser.setLastname(user.getLastname());
		existingUser.setGender(user.getGender());
		existingUser.setDob(user.getDob());
		existingUser.setPhone(user.getPhone());
		existingUser.setLocation(user.getLocation());
		existingUser.setEmail(user.getEmail());

		// save updated student object
		userService.updateUser(existingUser);
		return "redirect:/user/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUserById(id);
		return "redirect:/user/list";
	}

}
