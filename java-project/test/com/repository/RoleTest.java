package com.repository;

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
}
