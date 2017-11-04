package com.sgaidai.secondary;

import static com.sgaidai.jsfbean.controller.Cart.createdorder_id;
import com.sgaidai.jsfbean.controller.UserBean;
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
    private Orders order;
    
    public List<Orders> getAllorders(){        
        List <Orders> allorders = this.orderDAO.listAllOrders();
        return allorders;        
    }       
     public List<Orders> listOrdersByBuyerId(){        
        List <Orders> allorders = this.orderDAO.listOrdersByBuyerId(UserBean.log.getUserId());
        return allorders;        
    } 
    public Orders getCreatedorder(){ 
        order  = this.orderDAO.getOrderById(createdorder_id);
        
        return order ;    
    }  
    
    public void methodOne(){ 
        System.out.println("methodOne"); 
    }
    
    public void methodTwo(){
         System.out.println("methodTwo");
    }
    
    
}
