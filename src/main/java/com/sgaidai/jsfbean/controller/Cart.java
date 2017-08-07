
package com.sgaidai.jsfbean.controller;

import com.sgaidai.secondary.Growl;
import com.sgaidai.secondary.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ApplicationScoped
@Getter
@Setter
@ToString
@ManagedBean(name="cart")
public class Cart implements  Serializable {
    
    private  List <Product> mycart ;
    private int price;
    private int id;
    private String category ;
    int total;
    
    public Cart(){
        this.mycart = new ArrayList();
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
	this.category = params.get("category");
        this.id = Integer.parseInt(params.get("id"));
        this.price = Integer.parseInt(params.get("price"));
        System.out.println( "Added to MyCart :" + category + "...."+ id+"...."+price);
        Product product = new Product();
        product.setCategory(category);
        product.setId(id);
        product.setPrice(price);
    //    System.out.println(product.toString());
        mycart.add(product);
        System.out.println( mycart.size() + " items in cart");
        Growl growl = new Growl();
        growl.saveMessage("Added to cart !!!");
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
    
    public void buyAll(){
//         after ordering;
        mycart.clear();
    }
    public void buyOne(int index){
        
        // after ordering;
        mycart.remove(mycart.indexOf(index));
    }   
}
