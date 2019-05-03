package com.controller;

import com.repository.LocationRepository;

import java.util.List;
import com.model.Location;

public class LocationController {
	private LocationRepository locationRepository = new LocationRepository();
	List<Location> locations;
	
	public List<Location> getLocations() {
		if (locations == null) {
			locations = locationRepository.getAllLocations();
		}
		return locations;
	}

}

