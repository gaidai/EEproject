package com.sgaidai.security.service;

import java.util.List; 
import javax.annotation.Resource; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sgaidai.security.entities.model.Role;
import com.sgaidai.springdatajpa.dao.repositories.RoleRepository;
import com.sgaidai.springdatajpa.exception.UserRoleNotFoundException;



@Service
public class RoleServiceImpl implements RoleService{
    
    @Resource
    private RoleRepository roleRepository;
 
    @Override
    @Transactional
    public Role create(Role role) {
        Role createdRole = role;
        role.toString();
        return roleRepository.save(createdRole);
       
    }
    
    @Override
    @Transactional
    public int CreateNewRoleId() {
      int maxUserRoleId = roleRepository.getMaxRoleId();
     // maxEmpId =(maxEmpId==null)?"0":maxEmpId;
        return maxUserRoleId+1;
    }
     
    @Override
    @Transactional
    public Role findById(Integer userId) {
        return roleRepository.findOne(userId);
    }
 
    
    @Override
    @Transactional
    public List<Role> findAll() {
        System.out.println("I am Inside UserRole Service");
        return roleRepository.findAll();
    }
 
    
    
}
