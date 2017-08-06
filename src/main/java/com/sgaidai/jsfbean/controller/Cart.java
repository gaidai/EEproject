
package com.sgaidai.jsfbean.controller;

import com.sgaidai.secondary.Growl;
import com.sgaidai.secondary.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@ManagedBean(name="cart")
public class Cart {
    
    private static List <Product> mycart = new ArrayList();
    private int price;
    private int id;
    private String category ;
    
    public String getSize(){        
        if ( mycart.isEmpty()){
            return "";   
        } else{ 
          String size = "(" + mycart.size() + ")";
            return size;}
    }
    public List<Product> getCart(){        
        
            return mycart;
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
        int total = 0;
        for(Product p: mycart){
            total = total + p.getPrice();
        }
        return  total;
    }
    
    public void deletfromCart(int index){
        mycart.remove(mycart.indexOf(index));
    }
    
    public void clearCart(){
        mycart.clear();
        Growl growl = new Growl();
        growl.saveMessage("Your shopping cart is cleared!");
         System.out.println( "Cart is cleared");
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
