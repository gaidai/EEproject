
package com.sgaidai.springdatajpa.dao;

import com.sgaidai.security.entities.model.product.Camera;
import java.util.List;
import javax.inject.Named;


@Named
public interface Order_detail {
    
    public void addOrder_detail(Order_detail od) ;      
       
    public List<Order_detail> listOrder_detailById();
    
    public List<Order_detail> listCamerasbyPrice();
               
    public void deleteOrder_detail(Order_detail o);
        
    public Camera getOrder_detailById(int id) ;
    
}
