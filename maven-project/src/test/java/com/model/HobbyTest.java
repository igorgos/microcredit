package com.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import com.model.Hobby;
import com.repository.PersistenceManager;

public class HobbyTest {

	@Test
	public void testAllHobbies() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT hobby  FROM Hobby hobby");
		@SuppressWarnings("unchecked")
		List<Hobby> hobbies = query.getResultList();
		System.out.println("roles = " + hobbies);
		assertNotNull(hobbies);
		assertTrue(hobbies.size() > 0);
	}
	
	@Test
	public void testAllHobbiesFetchUsers() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT DISTINCT hobby  "
				+ "FROM Hobby hobby "
				+ "JOIN FETCH hobby.users");
		@SuppressWarnings("unchecked")
		List<Hobby> hobbies = query.getResultList();
		System.out.println("Hobbies = " + hobbies);
		assertNotNull(hobbies);
		assertTrue(hobbies.size() > 0);
		for (Hobby b : hobbies) {
			System.out.println("b = " + b);
			assertNotNull(b.getUsers());
			assertTrue(b.getUsers().size() > 0);
		}
	
	}
	
}
