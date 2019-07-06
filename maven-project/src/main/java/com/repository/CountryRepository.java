package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Country;

public class CountryRepository {
	private static final Logger logger = LoggerFactory.getLogger(CountryRepository.class);
	private EntityManager entityManager = PersistenceManager.createPersistenceManager();

	public Country save(Country country) {
<<<<<<< HEAD
		logger.info("Country: {}, {}", country.getName(), country.getPhone());
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		if(country.getId() == null) {
			entityManager.persist(country);
		} else { 
			entityManager.merge(country);
		}
=======
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(country);
>>>>>>> origin/master
		transaction.commit();
		return country;
	}
		
	public List<Country> getAllCountries() {
		Query query = entityManager.createQuery("SELECT country "
				+ "FROM Country country");
		@SuppressWarnings("unchecked")
		List<Country> countries = query.getResultList();
		logger.info("Contries: {}", countries);
		return countries;
	}

	public List<Country> getCountriesByName(String name) {
		Query query = entityManager.createQuery("SELECT country "
				+ "FROM Country country WHERE country.name LIKE :name");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<Country> countries = query.getResultList();
		logger.info("Contries: {}", countries);
		return countries;
	}

	public List<Country> getCountriesByNameCaseInsensitive(String name) {
		Query query = entityManager.createQuery("SELECT country "
				+ "FROM Country country WHERE LOWER(country.name) LIKE LOWER(:name)");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<Country> countries = query.getResultList();
		logger.info("Contries: {}", countries);
		return countries;
	}
	
	public List<Country> getCountriesByIds() {
		Query query = entityManager.createQuery("SELECT country "
				+ "FROM Country country WHERE id IN(1,2,3)");
		@SuppressWarnings("unchecked")
		List<Country> countries = query.getResultList();
		logger.info("Contries: {}", countries);
		return countries;
	}

	public void delete(Integer countryId) {
		Query query = entityManager.createQuery("DELETE FROM Country WHERE id = :countryId");
		query.setParameter("countryId", countryId);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		query.executeUpdate();
		transaction.commit();
	}
	
	public Country getById(Integer countryId) {
		Query query = entityManager.createQuery("FROM Country WHERE id = :countryId");
		//Query query = entityManager.createQuery("SELECT country FROM Country country WHERE country.id = :countryId");
		query.setParameter("countryId", countryId);
		Country country = (Country) query.getSingleResult();
		return country;
	}

}
