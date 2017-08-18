
package com.sgaidai.jsfbean.controller;

import com.sgaidai.secondary.Growl;
import com.sgaidai.secondary.Ordering;
import com.sgaidai.security.entities.model.product.Order_detail;
import com.sgaidai.security.entities.model.product.Orders;
import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.springdatajpa.dao.Order_DetailDAO;
import com.sgaidai.springdatajpa.dao.OrdersDAO;
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
@ManagedBean(name="cart")
public class Cart implements  Serializable {
    
    
    private  List <Product> mycart;
    private Product item;
    private int total;
    
    @Autowired
    ProductDAO productDAO ;
    @Autowired
    private OrdersDAO orderDAO ;    
    @Autowired
    private Order_DetailDAO order_DetailDAO ;
    
    public Cart(){
        this.mycart = new ArrayList();
    }
    
    public String buyAll(){
        
        Orders neworder = new Orders();
        int buyer_id = 55;
        neworder.setBuyer_id(buyer_id);
        neworder.setTotal(total);
        Orders creatrdorder = this.orderDAO.addOrder(neworder);
        System.out.println(creatrdorder.getId()+"#############");
        List <Order_detail> odlist = new ArrayList();
        for (Product p: mycart){
            Order_detail od = new Order_detail();
            od.setFixed_price(p.getPrice());
            od.setProduct_id(p);
            od.setOrder_id(creatrdorder);
            odlist.add(od);
        }
        
        
        this.order_DetailDAO.addOrder_Detail(odlist);
        System.out.println("Order Created : " );
//         after ordering;
        mycart.clear();
        return "home";
    }
    
    public void buyOne(Product p){
        
        Ordering order = new Ordering();
//        List <Product> one_product = new ArrayList();
//        order.createOrder(one_product,p.getPrice());  
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
