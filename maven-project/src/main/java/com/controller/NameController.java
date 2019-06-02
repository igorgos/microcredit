package com.controller;

import java.util.List;

import com.model.Name;
import com.repository.NameRepository;

public class NameController {
	private NameRepository nameRepository = new NameRepository();
	List<Name> names;


	public List<Name> getNames() {
		if (names == null) {
			names = nameRepository.getAllNames();
		}
		return names;
	}
	
	public Name save(Name name) {
		return nameRepository.save(name);
	}
}
