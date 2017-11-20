/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.springdatajpa.dao;

import com.sgaidai.security.entities.model.product.Orders_Detail;
import java.util.List;
import javax.inject.Named;


@Named
public interface Orders_DetailDAO {
    
    public void addOrder_Detail (List <Orders_Detail> list) ;      
       
    
    
}
