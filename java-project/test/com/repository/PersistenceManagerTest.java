package com.repository;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;

public class PersistenceManagerTest {
	
	@Test
	public void testEntityManager() {
		EntityManager entityManager = PersistenceManager.createPersistenceManager();
		assertNotNull(entityManager);
	}
}
