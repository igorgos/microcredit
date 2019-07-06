package com.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.model.Hobby;

public class HobbyRepository {
	private static final Logger logger = LoggerFactory.getLogger(HobbyRepository.class);
	private EntityManager entityManager = PersistenceManager.createPersistenceManager();
	
	public Hobby save(Hobby hobby) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(hobby);
		transaction.commit();
		return hobby;
	}
	
	public List<Hobby> getAllHobbies() {
		Query query = entityManager.createQuery("SELECT hobby "
				+ "FROM Hobby hobby");
		@SuppressWarnings("unchecked")
		List<Hobby> hobbies = query.getResultList();
		logger.info("Hobbies: {}", hobbies);
		return hobbies;
	}
	
	public List<Hobby> getHobbiesByName(String name) {
		Query query = entityManager.createQuery("SELECT hobby "
				+ "FROM Hobby hobby WHERE hobby.name LIKE :name");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<Hobby> hobbies = query.getResultList();
		logger.info("Hobbies: {}", hobbies);
		return hobbies;
	}

	public List<Hobby> getHobbiesByNameCaseInsensitive(String name) {
		Query query = entityManager.createQuery("SELECT hobby "
				+ "FROM Hobby hobby WHERE LOWER(hobby.name) LIKE LOWER(:name)");
		query.setParameter("name", "%"+name+"%");
		@SuppressWarnings("unchecked")
		List<Hobby> hobbies = query.getResultList();
		logger.info("Hobby: {}", hobbies);
		return hobbies;
	}
	
	public Hobby getById(Integer hobbyId) {
		Query query = entityManager.createQuery("SELECT hobby "
				+ "FROM Hobby hobby WHERE hobby.id = :hobbyId ");
		query.setParameter("hobbyId", hobbyId);
		@SuppressWarnings("unchecked")
		Hobby hobby = (Hobby) query.getSingleResult();
		logger.info("Hobby: {}", hobby);
		return hobby;
	}
	
	public void delete(Integer hobbyId) {
		Query query = entityManager.createQuery("DELETE FROM Hobby WHERE id = :hobbyId");
		query.setParameter("hobbyId", hobbyId);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		query.executeUpdate();
		transaction.commit();
	}
	
}
