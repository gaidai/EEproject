package com.sgaidai.jsfbean.controller;


import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.springdatajpa.dao.ProductDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
@Named 
@ManagedBean(name="checkedService")
@SessionScoped
public class CheckedService implements Serializable{        
        
	@Autowired
	private ProductDAO productDAO;
        
        private List <Product> list = new ArrayList();
        
        
//        @Cacheable(value="itemlist", key="#name")
	public void listTop() {
		list = this.productDAO.getTop("top");
	    System.out.println(list.size()+"  ---- top products");
        }        
}
