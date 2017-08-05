
package com.sgaidai.jsfbean.controller;

import com.sgaidai.secondary.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
@ManagedBean(name="cart")
public class Cart {
    private static List <Product> cart = new ArrayList();
    private int price;
    private int id;
    private String category ;
    
    public void AddtoCart(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	this.category = params.get("category");
        this.id = Integer.parseInt(params.get("id"));
        this.price = Integer.parseInt(params.get("price"));
        System.out.println(category + "...."+ id+"...."+price);
        Product product = new Product();
        product.setCategory(category);
        product.setId(id);
        product.setPrice(price);
    //    System.out.println(product.toString());
        cart.add(product);
        System.out.println( cart.size());
    }
    public void DeletfromCart(int index){
        cart.remove(cart.indexOf(index));


    }
    public void ClearCart(){
        cart.clear();
    }
    
    public void buyAll(){

        
//         after ordering;
        cart.clear();
    }
    public void buyOne(int index){
        
        
        // after ordering;
        cart.remove(cart.indexOf(index));
    }
}
