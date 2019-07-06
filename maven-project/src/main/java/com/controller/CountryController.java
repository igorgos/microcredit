package com.controller;

import java.util.Date;
import java.util.List;

import com.model.Country;
import com.repository.CountryRepository;

public class CountryController {
	private CountryRepository countryRepository = new CountryRepository();
	private List<Country> countries;
	private Country selectedCountry;

	public Date getTime() {
		return new Date();
	}

	public Country getSelectedCountry() {
		return selectedCountry;
	}

	public void setSelectedCountry(Country selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public List<Country> getCountries() {
		if (countries == null) {
			countries = countryRepository.getAllCountries();
		}
		return countries;
	}

	public Country save(Country country) {
		System.out.println(country.getName());
		System.out.println(country.getPhone());
		return countryRepository.save(country);
	}

	public void delete(Integer countryId) {
		countryRepository.delete(countryId);
	}
	
	public Country getById(Integer countryId) {
		return countryRepository.getById(countryId);
	}
	
	public void setSelectedCountry(Integer countryId) {
		selectedCountry = countryRepository.getById(countryId);
	}
}
