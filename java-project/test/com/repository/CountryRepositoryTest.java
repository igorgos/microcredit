package com.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Country;

public class CountryRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(CountryRepositoryTest.class);
	private CountryRepository countryRepository = new CountryRepository();
	
	@Test
	public void testCountryRepository() {
		assertNotNull(countryRepository);
	}

	@Test
	public void testGetAllCountries() {
		List<Country> countries = countryRepository.getAllCountries();
		assertNotNull(countries);
		logger.info("Countries: {}", countries);
	}

	@Test
	public void testGetAllCountrys() {
		String name = "Mo";
		List<Country> countries = countryRepository.getCountriesByName(name);
		assertNotNull(countries);
		logger.info("Countries: {}", countries);
		assertTrue(countries.size() > 0);
	}

	@Test
	public void testGetAllCountrysLowerCase() {
		String name = "mo";
		List<Country> countries = countryRepository.getCountriesByName(name);
		assertNotNull(countries);
		logger.info("Countries: {}", countries);
		assertTrue(countries.size() == 0);
	}

	@Test
	public void testGetAllCountrysCaseInsensitive() {
		String name = "MO";
		List<Country> countries = countryRepository.getCountriesByNameCaseInsensitive(name);
		assertNotNull(countries);
		logger.info("Countries: {}", countries);
		assertTrue(countries.size() > 0);
	}
	
//	@Test
//	public void testSave() {
//		Country country = new Country();
//	    country.setName("Bulgaria");
//	    Country savedCountry = countryRepository.save(country);
//	    assertNotNull(savedCountry.getId());
//	}
}
