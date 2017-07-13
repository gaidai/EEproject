package com.sgaidai.security.service;

import java.util.List; 
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sgaidai.security.entities.model.User;
import com.sgaidai.security.service.UserService;
;
import com.sgaidai.springdatajpa.dao.repositories.UserRepository;
import com.sgaidai.springdatajpa.dao.repositories.UserRepository;
import com.sgaidai.springdatajpa.exception.UserNotFoundException;

/**
 *
 * @author Raichand
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserRepository userRepository;
 
    @Override
    @Transactional
    public User create(User user) {
        User createdUser = user;
        return userRepository.save(createdUser);
    }
    
    @Override
    @Transactional
    public int CreateNewUserId() {
      int maxUserId = userRepository.getMaxUserId();
      System.out.println("Maximum id  is :-" +  maxUserId);
     // maxEmpId =(maxEmpId==null)?"0":maxEmpId;
        return maxUserId+1;
    }
     
    @Override
    @Transactional
    public User findById(Integer Userid) {
        return userRepository.findOne(Userid);
    }
 
   
 
    @Override
    @Transactional
    public List<User> findAll() {
        System.out.println("I am Inside User Service");
        return userRepository.getAllUser();
    }
 
    
    
}
