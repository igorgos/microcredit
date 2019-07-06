package com.controller;

import com.repository.RoleRepository;

import java.util.List;

import com.model.Role;

public class RoleController {
	private RoleRepository roleRepository = new RoleRepository();
	List<Role> roles;
	
	public List<Role> getRoles() {
		if (roles == null) {
			roles = roleRepository.getAllRoles();
		}
		return roles;
	}
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	
	public Role getById(Integer roleId) {
		return roleRepository.getById(roleId);
	}
	
	public void delete(Integer roleId) {
		roleRepository.delete(roleId);
	}
}

