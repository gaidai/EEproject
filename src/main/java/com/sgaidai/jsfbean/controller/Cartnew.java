
package com.sgaidai.jsfbean.controller;

import com.sgaidai.secondary.Growl;
import com.sgaidai.secondary.Ordering;
import com.sgaidai.security.entities.model.product.Orders;
import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.springdatajpa.dao.OrderEntityDAO;
import com.sgaidai.springdatajpa.dao.ProductDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
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
@ManagedBean(name="cartnew")
public class Cartnew implements  Serializable {
    
    
    private  List <Product> mycart;
    Product item;
    int total;
    @Autowired
    ProductDAO productDAO ;
    
    
    public Cartnew(){
        this.mycart = new ArrayList();
    }
    
    public void buyAll(){
        
        Ordering order = new Ordering();
        order.createOrder(mycart,total); 
//         after ordering;
        mycart.clear();
    }
    
    public void buyOne(Product p){
        
        Ordering order = new Ordering();
        order.createOrder(p);  
        mycart.remove(p);
    }    
     
    public String getSize(){        
        if ( mycart.isEmpty()){
            return "";   
        } else{ 
          String size = "(" + mycart.size() + ")";
            return size;}
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
