package com.sgaidai.secondary;

import com.sgaidai.security.entities.model.product.Order_detail;
import com.sgaidai.security.entities.model.product.Orders;
import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.springdatajpa.dao.OrderEntityDAO;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
@Repository
@ApplicationScoped
@Getter
@Setter
@ToString
@ManagedBean(name="ordering")
public class Ordering {    
    
    @Autowired
    private OrderEntityDAO orderDAO ;
    
    public List<Orders> getAllorders(){
        
        List <Orders> allorders = orderDAO.listAllOrders();
        
        for(Orders o: allorders ){
            System.out.println( "Order Id: "+ o.getId() + " Total: " + o.getTotal());
            List <Order_detail> od =  o.getOrder_details();
                for(Order_detail d: od ){
                    System.out.println("Detail product_id: " + d.getProduct_id().getCategory() + " "+ d.getProduct_id().getId() + " Fixed price: " + d.getFixed_price());
                }  
        }
        return allorders;
        
    }
    
    
    public void createOrder(List <Product> mycart, int total){
//        Orde neworder = new Orde();
//        neworder.setTotal(total);
//        int buyer_id = 2;
//        neworder.setBuyer_id(buyer_id);
//        int order_id = orderDAO.addOrder(neworder);
        
    }
    
    public void createOrder(Product p){
        
        
//        Orde neworder = new Orde();
//        neworder.setTotal(p.getPrice());
//        int buyer_id = 2;
//        neworder.setBuyer_id(buyer_id);
//        int order_id = orderDAO.addOrder(neworder);
//        Order_detail order_detail = new Order_detail();
//        order_detail.setFixed_price(p.getPrice());
//        order_detail.setOrder_id(order_id);
//        order_detail.setProduct(p);
        
    }
    
    
}
