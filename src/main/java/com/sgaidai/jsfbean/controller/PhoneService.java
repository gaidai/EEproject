package com.sgaidai.jsfbean.controller;


import com.sgaidai.security.entities.model.product.Phone;
import com.sgaidai.springdatajpa.dao.PhoneDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;


@Getter
@Setter
@Named 
@ManagedBean(name="phoneService")
@ViewScoped
public class PhoneService implements Serializable{
                
	@Autowired
	private PhoneDAO phoneDAO;
        private Phone phone = new Phone();
        private List <Phone> list = new ArrayList();
        private List <Phone> fulllist = new ArrayList();
        // Rannge for the price slider
        private int max = 30000;
        private int min = 300;     
        
        @Cacheable(value="itemlist", key="#name")
	public void listPhones(String name) {            
		fulllist = this.phoneDAO.listPhones();
                list = fulllist;
                
	}
        	
        public void onSlideEnd() {
            this.list = new ArrayList();
            int price;
            for(Phone h: fulllist ){
                price = h.getProduct().getPrice();
                if(price <= max && price>= min  ){         
                     list.add(h);
                }
            } 
        }
        

       
//	public void addCamera(Camera c) {
//		this.cameraDAO.addCamera(c);
//	}
//        
//	public void deleteCamera(Camera c) {
//                this.cameraDAO.deleteCamera(c);
//	}
//              
//        public void listCamerasByBrand (){
//            System.out.println(this.phone.getProduct().getBrand() + "-----");
//            list = this.phoneDAO.listProductsByBrand(this.phone.getProduct().getBrand());
//		
//	}
////        
        
//        public List<Camera> listCamerasbyPrice() {
//		return this.cameraDAO.listCamerasbyPrice();
//	}
}
