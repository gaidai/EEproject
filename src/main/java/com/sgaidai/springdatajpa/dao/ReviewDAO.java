/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.springdatajpa.dao;

import com.sgaidai.security.entities.model.product.Review;
import javax.inject.Named;


@Named
public interface ReviewDAO {
    
    public void addReview (Review o) ;      
       
    
    
}
