package com.greatlearning.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.greatlearning.EmployeeManagementSystem.entity.User;
import com.greatlearning.EmployeeManagementSystem.repository.UserRepository;
import com.greatlearning.EmployeeManagementSystem.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserRepository userRepository;

	// Verify user name present for authentication
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MyUserDetails(user);
	}

	// Save or Create operation
	@Override
	public User saveUser(User user) {

		return userRepository.save(user);
	}

	// Read operation
	@Override
	public List<User> fetchUserList() {

		return userRepository.findAll();
	}

	// Update Operation
	@Override
	public User updateUser(User user, Integer userId) {

		User userDB = userRepository.findById(userId).get();

		if (Objects.nonNull(user.getUsername()) && !"".equalsIgnoreCase(user.getUsername())) {
			userDB.setUsername(user.getUsername());
		}

		return userRepository.save(userDB);
	}

	// Delete Operation
	@Override
	public void deleteUserById(Integer userId) {

		userRepository.deleteById(userId);

	}

	// Find User by ID
	@Override
	public User getUser(Integer Id) {

		return userRepository.getById(Id);

	}

}
