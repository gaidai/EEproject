package com.sgaidai.jsfbean.controller;


import com.sgaidai.secondary.Images;
import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.springdatajpa.dao.ProductDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;


@Getter
@Setter
@Named 
@ManagedBean(name="productService")
@ConversationScoped
public class ProductService implements Serializable{
        
        
	@Autowired
	private ProductDAO productDAO;
        private Product product = new Product();
        private List <Product> list = new ArrayList();
        	
	public List<Product> listProducts(String category) {
		return this.productDAO.listProductsByCategory(category);
	}
       
	public void addCamera(Product p) {
		this.productDAO.addProduct(p);
	}
        
	public void deleteProduct(Product p) {
                this.productDAO.deleteProduct(p);
	}
                        
        public void listProductsByBrand (){
            list = this.productDAO.listProductsByBrand(this.product.getBrand());		
	}
        
        public void getProductbyid() {
                product = this.productDAO.getProductbyid(this.product.getId());               
	}
                
        public List<String> image () {
                Images g = new Images();
                List <String> pics = g.getImages( product.getCategory(), product.getId());   
               return pics ;                
	}  
        
        public List<Product> listProductsbyPrice() {
		return this.productDAO.listProductsbyPrice();
	}
        
        @Cacheable(value="itemlist", key="#name")
	public void listTop(String name) {
		list = this.productDAO.getTop(name);
        } 
        public boolean isHeadphones () {
               return "headphones".equals(product.getCategory()) ;                
	} 
}
