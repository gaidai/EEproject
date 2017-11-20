package com.sgaidai.jsfbean.controller;


import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.springdatajpa.dao.ProductDAO;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

@Log4j2
@Getter
@Setter
@Named 
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
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("products/"+product.getCategory()+"/"+product.getId()).getFile());            
            List<String> images  = Arrays.asList( file.list(new FilenameFilter(){
                    private Pattern pattern = Pattern.compile( "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)");
                    @Override
                    public boolean accept(File dir,String name){
                        return pattern.matcher(name).matches();
                    }
                }   
            ));                
            return images ;                
	}  

        public boolean isHeadphones () {
               return "headphones".equals(product.getCategory()) ;                
	}
             
        @Cacheable(value="itemlist", key="#name")
	public void listTop(String name) {
		list = this.productDAO.getTop(name);
        } 
}
