package com.sgaidai.jsfbean.controller;




import com.sgaidai.security.entities.model.Person;
import com.sgaidai.springdatajpa.dao.PersonDao;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Named 
@ManagedBean(name="personService")
@SessionScoped
@Component
public class PersonService implements Serializable{

	@Autowired
	private PersonDao personDao;

	

	@Transactional(readOnly = true)
	public List<Person> listPersons() {
		return personDao.listPersons();

	}

}
