package com.greatlearning.EmployeeManagementSystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.greatlearning.EmployeeManagementSystem.entity.User;
import com.greatlearning.EmployeeManagementSystem.service.UserService;

@Controller
@RequestMapping("/api")
public class UserManagementSystemController {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Save or Create Operation
	@PostMapping("/user")
	@ResponseBody
	public User AddUser(@Validated @RequestBody User user) {

		String enCodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(enCodedPassword);
		return userService.saveUser(user);

	}

	// Read Operations
	@GetMapping("/user")
	@ResponseBody
	public List<User> GetUserList() {

		return userService.fetchUserList();

	}

	// Update Operation
	@PutMapping("/user/{Id}")
	@ResponseBody
	public User UpdateUser(@RequestBody User user, @PathVariable("Id") Integer Id) {
		return userService.updateUser(user, Id);

	}

	// Delete Operation
	@DeleteMapping("/user/{Id}")
	@ResponseBody
	public String DeleteUserById(@PathVariable("Id") Integer Id) {

		userService.deleteUserById(Id);
		return "Deleted Successfully";

	}

}
