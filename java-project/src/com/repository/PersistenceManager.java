package com.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	public static EntityManagerFactory persistenceFactory = Persistence.createEntityManagerFactory("AFTest");
	
	public static EntityManager createPersistenceManager() {
		return persistenceFactory.createEntityManager();
	}

}
