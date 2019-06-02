package com.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import com.model.Role;
import com.repository.PersistenceManager;

public class RoleTest {

	@Test
	public void testAllRoles() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT role  FROM Role role");
		@SuppressWarnings("unchecked")
		List<Role> roles = query.getResultList();
		System.out.println("roles = " + roles);
		assertNotNull(roles);
		assertTrue(roles.size() > 0);
	}
	
	@Test
	public void testFindRoleByName() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT role  FROM Role role WHERE name  = 'Director'");
		@SuppressWarnings("unchecked")
		List<Role> roles = query.getResultList();
		System.out.println("role = " + roles);
		assertNotNull(roles);
		assertTrue(roles.size() > 0);
	}
	
	@Test
	public void testFindRoleByName2() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT role  FROM Role role WHERE name  = :name");
		query.setParameter("name", "Director");
		@SuppressWarnings("unchecked")
		List<Role> roles = query.getResultList();
		System.out.println("role = " + roles);
		assertNotNull(roles);
		assertTrue(roles.size() > 0);
	}
	
	@Test
	public void testFindRolesById() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT role  FROM Role role WHERE id IN (1, 2)");
		@SuppressWarnings("unchecked")
		List<Role> roles = query.getResultList();
		System.out.println("roles = " + roles);
		assertNotNull(roles);
		assertTrue(roles.size() > 0);
	}
	
	@Test
	public void testGetRole() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Role role = entityManager.find(Role.class, 5);
		System.out.println("role = " + role);
		assertNotNull(role);
	}
	
	@Test
	public void testGetRole2() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Role role = entityManager.find(Role.class, 1);
		entityManager.close();
		System.out.println("role = " + role);
		assertNotNull(role);
	    assertNotNull(role.getUsers());
	    System.out.println("role = " + role.getUsers());
	}
	
	@Test
	public void testAllRolesFetchUsers() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT DISTINCT role  "
				+ "FROM Role role "
				+ "JOIN FETCH role.users");
		@SuppressWarnings("unchecked")
		List<Role> roles = query.getResultList();
		System.out.println("roles = " + roles);
		assertNotNull(roles);
		assertTrue(roles.size() > 0);
		for (Role b : roles) {
			System.out.println("b = " + b);
			assertNotNull(b.getUsers());
			assertTrue(b.getUsers().size() > 0);
		}
	}
}
