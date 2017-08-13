package com.sgaidai.jsfbean.controller;


import com.sgaidai.secondary.Images;
import com.sgaidai.security.entities.model.product.Phone;
import com.sgaidai.springdatajpa.dao.PhoneDAO;
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
@ManagedBean(name="phoneService")
@SessionScoped
public class PhoneService implements Serializable{
                
	@Autowired
	private PhoneDAO phoneDAO;
        private Phone phone = new Phone();
        private List <Phone> list = new ArrayList();
        	
	public List<Phone> listPhones() {            
		return this.phoneDAO.listPhones();
                
	}
        
        public List<String> image () {
                Images g = new Images();
                List <String> pics = g.getImages( "phones", phone.getId());   
               return pics ;                
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
        public void getPhoneById() {
                phone = this.phoneDAO.getPhoneById(this.phone.getId());
               
	}
//        public List<Camera> listCamerasbyPrice() {
//		return this.cameraDAO.listCamerasbyPrice();
//	}
}
