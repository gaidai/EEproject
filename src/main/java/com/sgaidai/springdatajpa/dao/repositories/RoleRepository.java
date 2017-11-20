package com.sgaidai.springdatajpa.dao.repositories;


import com.sgaidai.security.entities.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




public interface RoleRepository extends JpaRepository<Role,Integer>{
    
    @Query("SELECT max(r.roleId) FROM Role r")
   int getMaxRoleId();
    
}
