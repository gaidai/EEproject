

package com.sgaidai.springdatajpa.dao;


import com.sgaidai.security.entities.model.product.OrderEntity;
import java.util.List;
import javax.inject.Named;


@Named
public interface OrderEntityDAO {
    
    public void addOrder(OrderEntity o) ;      
       
    public List<OrderEntity> listAllOrders();
                   
    public void deleteOrder(OrderEntity o);
    
    public List<OrderEntity> listOrdersByBuyerId(int id);
    
    public OrderEntity getOrderById(int id) ;
    
}
