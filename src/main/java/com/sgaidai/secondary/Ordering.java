package com.sgaidai.secondary;

import com.sgaidai.security.entities.model.product.Order_Detail;
import com.sgaidai.security.entities.model.product.Orders;
import java.util.List;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.sgaidai.springdatajpa.dao.OrdersDAO;
import javax.enterprise.context.RequestScoped;

@RequestScoped
@Service
@Repository
@Getter
@Setter
@ToString
@ManagedBean(name="ordering")
public class Ordering {    
    
    @Autowired
    private OrdersDAO orderDAO ;
    
    public List<Orders> getAllorders(){
        
        List <Orders> allorders = this.orderDAO.listAllOrders();
        
        for(Orders o: allorders ){
            System.out.println( "Order Id: "+ o.getId() + " Total: " + o.getTotal());
            List <Order_Detail> od =  o.getOrder_details();
                for(Order_Detail d: od ){
                    System.out.println("Detail product_id: " + d.getProduct_id().getCategory() + " "+ d.getProduct_id().getId() + " Fixed price: " + d.getFixed_price());
                }  
        }
        return allorders;
        
    }
    
  
   
}
