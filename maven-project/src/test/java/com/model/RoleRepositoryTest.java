package com.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Role;
import com.repository.RoleRepository;

public class RoleRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(RoleRepositoryTest.class);
	private RoleRepository roleRepository = new RoleRepository();
	
	@Test
	public void testRoleRepository() {
		assertNotNull(roleRepository);
	}

	@Test
	public void testGetAllRoles() {
		List<Role> roles = roleRepository.getAllRoles();
		assertNotNull(roles);
		logger.info("Roles: {}", roles);
	}

	@Test
	public void testGetRolesByName() {
		String name = "Co";
		List<Role> roles = roleRepository.getRolesByName(name);
		assertNotNull(roles);
		logger.info("Roles: {}", roles);
		assertTrue(roles.size() > 0);
	}

	@Test
	public void testGetRolesByNameCaseInsensitive() {
		String name = "CO";
		List<Role> roles = roleRepository.getRolesByNameCaseInsensitive(name);
		assertNotNull(roles);
		logger.info("Roles: {}", roles);
		assertTrue(roles.size() > 0);
	}
	
}
