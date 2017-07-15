
package com.sgaidai.springdatajpa.dao;


import com.sgaidai.security.entities.model.Person;
import java.util.List;
import javax.inject.Named;


public interface PersonDao {
        
	public void addPerson(Person p) ;
        
       
	public List<Person> listPersons();
        
       
        public void deletePerson(Person p);
}
