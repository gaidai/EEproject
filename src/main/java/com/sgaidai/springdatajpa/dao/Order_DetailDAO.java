
package com.sgaidai.springdatajpa.dao;

import com.sgaidai.security.entities.model.product.Order_detail;
import java.util.List;
import javax.inject.Named;


@Named
public interface Order_DetailDAO {
    
    public void addOrder_Detail(List <Order_detail> list) ;      
       
               
    
}
