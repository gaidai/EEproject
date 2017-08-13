/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.springdatajpa.dao;

import com.sgaidai.security.entities.model.product.Product;
import java.util.List;
import javax.inject.Named;


@Named
public interface ProductDAO {
    
    public void addProduct(Product p) ;      
       
    public List<Product> listProductsByCategory(String category);
    
    public List<Product> listProductsbyPrice();
               
    public void deleteProduct(Product p);
    
    public List<Product> listProductsByBrand(String b);
    
    public Product getProductbyid(int id) ;
    
}
