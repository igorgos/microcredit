package com.controller;

import java.util.Date;
import java.util.List;

import com.model.Country;
import com.repository.CountryRepository;

public class CountryController {
	private CountryRepository countryRepository = new CountryRepository();
	List<Country> countries;

	public Date getTime() {
		return new Date();
	}

	public List<Country> getCountries() {
		if (countries == null) {
			countries = countryRepository.getAllCountries();
		}
		return countries;
	}
}
