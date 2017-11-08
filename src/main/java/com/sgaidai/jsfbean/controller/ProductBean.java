package com.sgaidai.jsfbean.controller;


import com.sgaidai.secondary.Images;
import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.springdatajpa.dao.ProductDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;


@Getter
@Setter
@Named 
@ManagedBean(name="productBean")
@ViewScoped
public class ProductBean implements Serializable{
        
        @Autowired
	private ProductDAO productDAO;
        private Product product = new Product();
        private List <Product> list = new ArrayList();    
        
        public void getProductbyid() {
                this.product = this.productDAO.getProductbyid(this.product.getId());               
	}
        
        public List<String> image () {
                Images g = new Images();
                List <String> pics = g.getImages( product.getCategory(), product.getId());   
               return pics ;                
	}  

        public boolean isHeadphones () {
               return "headphones".equals(product.getCategory()) ;                
	}
             
        @Cacheable(value="itemlist", key="#name")
	public void listTop(String name) {
		list = this.productDAO.getTop(name);
        } 
}
