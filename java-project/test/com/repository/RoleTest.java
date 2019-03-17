package com.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import com.model.Role;

public class RoleTest {

	@Test
	public void testAllRoles() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT role  FROM Role role");
		List<Role> roles = query.getResultList();
		System.out.println("roles = " + roles);
		assertNotNull(roles);
//		assertTrue(roles.size() > 0);
		assertEquals(2, roles.size());
	}
}
