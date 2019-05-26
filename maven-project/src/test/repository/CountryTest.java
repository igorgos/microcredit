package com.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import com.model.Country;

public class CountryTest {
	
	@Test
	public void testAllCountrys() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		Query query = entityManager.createQuery("SELECT country "
				+ "FROM Country country");
		@SuppressWarnings("unchecked")
		List<Country> countries = query.getResultList();
		assertNotNull(countries);
		assertTrue(countries.size() > 0);
	}

}
