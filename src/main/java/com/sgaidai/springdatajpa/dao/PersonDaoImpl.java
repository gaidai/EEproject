package com.sgaidai.springdatajpa.dao;



import com.sgaidai.security.entities.model.Person;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Named
@Service
@Repository
@RequestScoped
public class PersonDaoImpl implements PersonDAO {
    
        @Autowired
	private EntityManager em;
        
        @Transactional
        @Override
	public void addPerson(Person p) {
		this.em.persist(p);
	}
        
        @Transactional 
        @Override
	public List<Person> listPersons() {
		return this.em.createQuery("SELECT p FROM Person p").getResultList();
	}
        
        @Transactional
        @Override
        public void deletePerson(Person l ) {
            Person p = new Person(l.getId(),l.getName(), l.getCountry());
            System.out.println("************ " + l.getId() + " ************");
		p = em.merge(p);
            this.em.remove(p);

	}

       

}
