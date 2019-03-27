package com.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.model.Country;

public class CountryRepositoryTest {
	private CountryRepository countryRepository = new CountryRepository();
	
	@Test
	public void testCountryRepository() {
		assertNotNull(countryRepository);
	}

	@Test
	public void testGetAllCountries() {
		List<Country> countries = countryRepository.getAllCountries();
		assertNotNull(countries);
	}

	@Test
	public void testGetAllCountrys() {
		String name = "Mo";
		List<Country> countries = countryRepository.getCountriesByName(name);
		assertNotNull(countries);
	}

}
