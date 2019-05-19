package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Name;

public class NameRepository {
	private static final Logger logger = LoggerFactory.getLogger(NameRepository.class);
	private EntityManager entityManager = PersistenceManager.createPersistenceManager();

	public Name save(Name name) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(name);
		transaction.commit();
		return name;
	}
	
	public List<Name> getAllNames() {
		Query query = entityManager.createQuery("SELECT name "
				+ "FROM Name name");
		@SuppressWarnings("unchecked")
		List<Name> names = query.getResultList();
		logger.info("Names: {}", names);
		return names;
	}

}
