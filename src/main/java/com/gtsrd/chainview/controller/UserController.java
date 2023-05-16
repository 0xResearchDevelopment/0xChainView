package com.gtsrd.chainview.controller;

import com.gtsrd.chainview.dto.UserRegistrationDto;
import com.gtsrd.chainview.model.User;
import com.gtsrd.chainview.response.ApiResponse;
import com.gtsrd.chainview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/retriveAll")
    public List<User> retriveEvents() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public ApiResponse registerUser(UserRegistrationDto userRegistrationDto) {
        return userService.save(userRegistrationDto);
    }

    @GetMapping("/retriveById/{id}")
    public User retriveUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/retriveByEmail/{email}")
    public User retriveUserByEmail(@PathVariable String email) {
        return userService.checkIfRegisteredUser(email);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

}
