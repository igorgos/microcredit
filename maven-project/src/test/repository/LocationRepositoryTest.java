package com.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Location;

public class LocationRepositoryTest {
	private static final Logger logger = LoggerFactory.getLogger(CountryRepositoryTest.class);
	private LocationRepository locationRepository = new LocationRepository();
	
	@Test
	public void testLocationRepository() {
		assertNotNull(locationRepository);
	}

	@Test
	public void testGetAllLocations() {
		List<Location> locations = locationRepository.getAllLocations();
		assertNotNull(locations);
		logger.info("Locations: {}", locations);
	}

	@Test
	public void testGetAllLocationsByName() {
		String name = "Bra";
		List<Location> locations = locationRepository.getLocationsByName(name);
		assertNotNull(locations);
		logger.info("Locations: {}", locations);
		assertTrue(locations.size() > 0);
	}

	@Test
	public void testGetAllLocationsLowerCase() {
		String name = "bra";
		List<Location> locations = locationRepository.getLocationsByName(name);
		assertNotNull(locations);
		logger.info("Locations: {}", locations);
		assertTrue(locations.size() == 0);
	}

	@Test
	public void testGetAllLocationsCaseInsensitive() {
		String name = "BRA";
		List<Location> locations = locationRepository.getLocationsByNameCaseInsensitive(name);
		assertNotNull(locations);
		logger.info("Locations: {}", locations);
		assertTrue(locations.size() > 0);
	}
}
