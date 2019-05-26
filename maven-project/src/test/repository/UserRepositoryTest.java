package com.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.User;

public class UserRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);
	private UserRepository userRepository = new UserRepository();
	
	@Test
	public void testUserRepository() {
		assertNotNull(userRepository);
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = userRepository.getAllUsers();
		assertNotNull(users);
		logger.info("Users: {}", users);
	}

	@Test
	public void testGetUsersByName() {
		String name = "Io";
		List<User> users = userRepository.getUsersByName(name);
		assertNotNull(users);
		logger.info("Users: {}", users);
		assertTrue(users.size() > 0);
	}

	@Test
	public void testGetUsersByNameCaseInsensitive() {
		String name = "AL";
		List<User> users = userRepository.getUsersByNameCaseInsensitive(name);
		assertNotNull(users);
		logger.info("Users: {}", users);
		assertTrue(users.size() > 0);
	}
	
}
