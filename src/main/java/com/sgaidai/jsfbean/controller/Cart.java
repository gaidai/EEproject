
package com.sgaidai.jsfbean.controller;

import com.sgaidai.secondary.Growl;
import com.sgaidai.security.entities.model.User;
import com.sgaidai.security.entities.model.product.Orders;
import com.sgaidai.security.entities.model.product.Orders_Detail;
import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.springdatajpa.dao.OrdersDAO;
import com.sgaidai.springdatajpa.dao.Orders_DetailDAO;
import com.sgaidai.springdatajpa.dao.ProductDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Repository
@ApplicationScoped
@Getter
@Setter
@ToString
@Named
public class Cart implements  Serializable {
    
    
    private  List <Product> mycart;
    private Product item;
    private int total;
    
    @Autowired
    ProductDAO productDAO ;
    @Autowired
    private OrdersDAO orderDAO ;    
    @Autowired
    private Orders_DetailDAO order_DetailDAO ;
    private Orders neworder = new Orders();
    private Orders createdorder = new Orders();
    public static int createdorder_id ;
    private String ln = null;
    
    public Cart(){
        this.mycart = new ArrayList();
    }
            
    public String buyAll(){
        
        neworder.setTotal(total);
        neworder.setStatus("created");
        if( !SecurityContextHolder.getContext().getAuthentication().getPrincipal().getClass().equals(String.class) ){
            neworder.setUserId((User) log);
        } 
        Orders creatorder = this.orderDAO.addOrder(neworder);
        int created_id= creatorder.getId();
        List <Orders_Detail> odlist = new ArrayList();
        for (Product p: mycart){
            Orders_Detail od = new Orders_Detail();
            od.setFixed_price(p.getPrice());
            od.setProduct_id(p);
            od.setOrder_id(creatorder);
            odlist.add(od);
        }     
        this.order_DetailDAO.addOrder_Detail(odlist);
        createdorder =  this.orderDAO.getOrderById(created_id);
        createdorder_id = createdorder.getId();
        neworder = new Orders();
//         after ordering clear the shopping cart created_order.xhtml?id="+created_id
        mycart.clear();
        return "created_order";
    }
    
    public String buyOne(Product p){
        
        Orders neworder = new Orders();
        int buyer_id = 12;
        neworder.setTotal(total);
        Orders creatrdorder = this.orderDAO.addOrder(neworder);
        List <Orders_Detail> odlist = new ArrayList();        
        Orders_Detail od = new Orders_Detail();
        od.setFixed_price(p.getPrice());
        od.setProduct_id(p);
        od.setOrder_id(creatrdorder);
        odlist.add(od);
                
        this.order_DetailDAO.addOrder_Detail(odlist);
  //     delet ordered product from the shopping cart  
        mycart.remove(p);
        return "home";
    }   
    public void AddtoCart(){
          
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();	
        int product_id = Integer.parseInt(params.get("product_id"));
        item = this.productDAO.getProductbyid(product_id);
        
        if(item.getQuantity()<1 ){
            Growl growl = new Growl();
            growl.saveMessage("Sorry, but this model was sold out !!!");
        } else{
            System.out.println( "Added to MyCart New :" + item.getCategory() + "...."+ item.getModel()+"...." + item.getPrice());        
            mycart.add(item);
            System.out.println( mycart.size() + " Items in new cart");
            Growl growl = new Growl();
            growl.saveMessage("Added to cart !!!");
        }
    }
    
    public int totalPrice(){
        total = 0;        
        for(Product p: mycart){
            total = total + p.getPrice();
        }
        return  total;
    }
    
    public void deletfromCart(Product p){
        mycart.remove(p);
        Growl growl = new Growl();
        growl.saveMessage("item has been deleted from your cart!");
        System.out.println( "Product deleted from cart");
        totalPrice();
    }
    
    public void clearCart(){
        mycart.clear();
        Growl growl = new Growl();
        growl.saveMessage("Your shopping cart is cleared!");
        totalPrice();
    }
    
  
}
