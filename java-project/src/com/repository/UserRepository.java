package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.User;

public class UserRepository {
	private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
	private EntityManager entityManager = PersistenceManager.createPersistenceManager();
	
	public User save(User user) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(user);
		transaction.commit();
		return user;
	}
	
	public List<User> getAllUsers() {
		Query query = entityManager.createQuery("SELECT user "
				+ "FROM User user");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		logger.info("All users: {}", users);
		return users;
	}
	
	public List<User> getUsersByName(String name) {
		Query query = entityManager.createQuery("SELECT user "
				+ "FROM User user WHERE user.name LIKE :name");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		logger.info("Users: {}", users);
		return users;
	}

	public List<User> getUsersByNameCaseInsensitive(String name) {
		Query query = entityManager.createQuery("SELECT user "
				+ "FROM User user WHERE LOWER(user.name) LIKE LOWER(:name)");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		logger.info("Users: {}", users);
		return users;
	}

	public User getUser(Integer userId) {
		Query query = entityManager.createQuery("SELECT user "
				+ "FROM User user JOIN FETCH user.role WHERE user.id = :userId");
		query.setParameter("userId", userId);
		User user = (User) query.getSingleResult();
		return user;
	}
	
}
