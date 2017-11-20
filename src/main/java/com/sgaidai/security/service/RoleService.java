package com.sgaidai.security.service;

import java.util.List; 
import com.sgaidai.security.entities.model.Role;
import com.sgaidai.springdatajpa.exception.UserRoleNotFoundException;
        
/**
 *
 * @author Raichand
 */
public interface RoleService {
    
    public Role create(Role userrole);
   
    public List<Role> findAll();
   
    public Role findById(Integer userRoleId);
    public  int CreateNewRoleId();
    
}
