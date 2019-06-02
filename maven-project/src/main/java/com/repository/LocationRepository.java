package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Location;

public class LocationRepository {
	private static final Logger logger = LoggerFactory.getLogger(LocationRepository.class);
	private EntityManager entityManager = PersistenceManager.createPersistenceManager();
	
	public Location save(Location location) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(location);
		transaction.commit();
		return location;
	}
	public List<Location> getAllLocations() {
		Query query = entityManager.createQuery("SELECT location "
				+ "FROM Location location");
		@SuppressWarnings("unchecked")
		List<Location> locations = query.getResultList();
		logger.info("Locations: {}", locations);
		return locations;
	}
	
	public List<Location> getLocationsByName(String name) {
		Query query = entityManager.createQuery("SELECT location "
				+ "FROM Location location WHERE location.name LIKE :name");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<Location> locations = query.getResultList();
		logger.info("Locations: {}", locations);
		return locations;
	}

	public List<Location> getLocationsByNameCaseInsensitive(String name) {
		Query query = entityManager.createQuery("SELECT location "
				+ "FROM Location location WHERE LOWER(location.name) LIKE LOWER(:name)");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<Location> locations = query.getResultList();
		logger.info("Location: {}", locations);
		return locations;
	}
	
}
