package com.controller;

import com.repository.UserRepository;

import java.util.List;
import com.model.User;

public class UserController {
	private UserRepository userRepository = new UserRepository();
	List<User> users;
	
	public List<User> getUsers() {
		if (users == null) {
			users = userRepository.getAllUsers();
		}
		return users;
	}

}

