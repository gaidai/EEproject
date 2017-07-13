package com.sgaidai.springdatajpa.dao;



import com.sgaidai.security.entities.model.Person;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PersonDao {

	@PersistenceContext
	private EntityManager em;

	public void persist(Person p) {
		em.persist(p);
	}

	public List<Person> listPersons() {
		return em.createQuery("SELECT p FROM Person p").getResultList();
	}

}
