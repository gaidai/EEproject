package com.sgaidai.jsfbean.controller;




import com.sgaidai.security.entities.model.Person;
import com.sgaidai.springdatajpa.dao.PersonDao;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;


@Named 
@ManagedBean(name="personService")
@SessionScoped
public class PersonService implements Serializable{

	@Autowired
	private PersonDao personDAO;

	
        
	
	public List<Person> listPersons() {
		return this.personDAO.listPersons();

	}
       
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);

	}
        
	public void deletePerson(Person p) {
                
            
		this.personDAO.deletePerson(p);

	}
        public void setPersonDAO(PersonDao personDAO) {
                this.personDAO = personDAO;
            }

        public PersonDao getPersonDAO() {
            return personDAO;
        }
        
}
