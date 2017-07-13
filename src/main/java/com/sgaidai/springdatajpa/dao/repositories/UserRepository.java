package com.sgaidai.springdatajpa.dao.repositories;

import com.sgaidai.security.entities.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer>{
     
      User findByUsername(String username);
    
@Query("SELECT max(u.userId) FROM User u")//Retrieving Maximun Id of User Record
   int getMaxUserId();
@Query("SELECT u.userId,u.firstName,u.lastName,u.username,u.email,u.password,u.enabled,r.role from User u,Role r WHERE u.userId = r.user")//Retrieving All User Records

    List<User>  getAllUser();
   
}
