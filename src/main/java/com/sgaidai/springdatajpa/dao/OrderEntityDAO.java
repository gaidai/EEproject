

package com.sgaidai.springdatajpa.dao;


import com.sgaidai.security.entities.model.product.Orders;
import java.util.List;
import javax.inject.Named;


@Named
public interface OrderEntityDAO {
    
    public int addOrder(Orders o);      
       
    public List<Orders> listAllOrders();
                   
    public void deleteOrder(Orders o);
    
    public List<Orders> listOrdersByBuyerId(int id);
    
    public Orders getOrderById(int id);
    
}
