/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.springdatajpa.dao;

import com.sgaidai.security.entities.model.product.Phone;
import java.util.List;
import javax.inject.Named;


@Named
public interface PhoneDAO {
    
    public void addPhone(Phone p) ;      
       
    public List<Phone> listPhones();
               
    public void deletePhone(Phone p);
    
    public Phone getPhoneById(int product_id);
    
//    public List<Phone> listPhonesByBrand(String b);
    
}
