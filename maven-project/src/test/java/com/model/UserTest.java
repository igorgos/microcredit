package com.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import com.model.User;
import com.repository.PersistenceManager;

public class UserTest {
	@Test
	public void testAllUsers() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT user  FROM User user");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		System.out.println("users = " + users);
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void testGetUser() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		User user = entityManager.find(User.class, 1);
		System.out.println("user = " + user);
		assertNotNull(user);
	}
	
	@Test
	public void testFindUserByLocation() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT user  FROM User user WHERE address = 'Romania'");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		System.out.println("user = " + users);
		assertNotNull(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void testFindUserByLocation2() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT user  FROM User user WHERE address = 'Romania'");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		entityManager.close();
		System.out.println("user = " + users);
		assertNotNull(users);
		assertTrue(users.size() > 0);
		for (User user: users) {
			assertNotNull(user.getRole());
			System.out.println("user = " + user.getRole());
		}
	}
	
	@Test
	public void testFindUserByLocation3() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT user  "
				+ "FROM User user "
				+ "JOIN FETCH user.role "
				+ "WHERE address = 'Romania'");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		System.out.println("user = " + users);
		assertNotNull(users);
		assertTrue(users.size() > 0);
		for (User user: users) {
			assertNotNull(user.getRole());
			System.out.println("user = " + user.getRole());
		}
	}
}
