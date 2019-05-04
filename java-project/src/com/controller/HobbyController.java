package com.controller;

import com.repository.HobbyRepository;

import java.util.List;
import com.model.Hobby;

public class HobbyController {
	private HobbyRepository hobbyRepository = new HobbyRepository();
	List<Hobby> hobbies;
	
	public List<Hobby> getHobbies() {
		if (hobbies == null) {
			hobbies = hobbyRepository.getAllHobbies();
		}
		return hobbies;
	}

}

