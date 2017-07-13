package com.sgaidai.security.service;
 
import java.util.List; 
import com.sgaidai.security.entities.model.User;
import com.sgaidai.springdatajpa.exception.UserNotFoundException;
        
/**
 *
 * @author Raichand
 */
public interface UserService {
    
    public User create(User user);   
    public List<User> findAll();   
    public User findById(Integer id);
    public  int CreateNewUserId();
    
    
}
