package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Role;

public class RoleRepository {
	private static final Logger logger = LoggerFactory.getLogger(RoleRepository.class);
	private EntityManager entityManager = PersistenceManager.createPersistenceManager();
	
	public List<Role> getAllRoles() {
		Query query = entityManager.createQuery("SELECT role "
				+ "FROM Role role");
		@SuppressWarnings("unchecked")
		List<Role> roles = query.getResultList();
		logger.info("All roles: {}", roles);
		return roles;
	}
	
	public List<Role> getRolesByName(String name) {
		Query query = entityManager.createQuery("SELECT role "
				+ "FROM Role role WHERE role.name LIKE :name");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<Role> roles = query.getResultList();
		logger.info("Roles: {}", roles);
		return roles;
	}

	public List<Role> getRolesByNameCaseInsensitive(String name) {
		Query query = entityManager.createQuery("SELECT role "
				+ "FROM Role role WHERE LOWER(role.name) LIKE LOWER(:name)");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<Role> roles = query.getResultList();
		logger.info("Roles: {}", roles);
		return roles;
	}
	
}
