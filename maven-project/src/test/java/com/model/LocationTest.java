package com.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import com.model.Location;
import com.repository.PersistenceManager;

public class LocationTest {
	
	@Test
	public void testAllLocations() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT location "
				+ "FROM Location location "
				+ "JOIN FETCH location.country");
		@SuppressWarnings("unchecked")
		List<Location> a = query.getResultList();
		assertNotNull(a);
		assertTrue(a.size() > 0);
		for (Location b : a) {
			System.out.println("b = " + b);
			assertNotNull(b.getCountry());
		}
	}

	@Test
	public void testSimpleAllLocations() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT location "
				+ "FROM Location location");
		@SuppressWarnings("unchecked")
		List<Location> locations = query.getResultList();
		assertNotNull(locations);
		assertTrue(locations.size() > 0);
	}
}
