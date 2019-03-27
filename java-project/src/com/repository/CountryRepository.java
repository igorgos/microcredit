package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.model.Country;

public class CountryRepository {
	private EntityManager entityManager = PersistenceManager.createPersistenceManager();

	public List<Country> getAllCountries() {
		Query query = entityManager.createQuery("SELECT country "
				+ "FROM Country country");
		@SuppressWarnings("unchecked")
		List<Country> countries = query.getResultList();
		return countries;
	}

	public List<Country> getCountriesByName(String name) {
		Query query = entityManager.createQuery("SELECT country "
				+ "FROM Country country WHERE country.name LIKE :name");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<Country> countries = query.getResultList();
		return countries;
	}
}
