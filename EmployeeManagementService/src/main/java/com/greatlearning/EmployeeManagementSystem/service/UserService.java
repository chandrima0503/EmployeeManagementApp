package com.greatlearning.EmployeeManagementSystem.service;

import java.util.List;

import com.greatlearning.EmployeeManagementSystem.entity.User;

public interface UserService {

	// Save operation
	User saveUser(User user);

	// Read operation
	List<User> fetchUserList();

	// Update operation
	User updateUser(User user, Integer userId);

	// Delete operation
	void deleteUserById(Integer userId);

	User getUser(Integer Id);
	
	}


