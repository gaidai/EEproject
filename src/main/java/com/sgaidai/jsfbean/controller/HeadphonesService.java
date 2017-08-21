package com.sgaidai.jsfbean.controller;


import com.sgaidai.secondary.Images;
import com.sgaidai.security.entities.model.product.Headphones;
import com.sgaidai.springdatajpa.dao.HeadphonesDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;


@Getter
@Setter
@Named 
@ManagedBean(name="headphonesService")
@SessionScoped
public class HeadphonesService implements Serializable {
        
        
	@Autowired
	private HeadphonesDAO headphonesDAO;
        private Headphones headphones = new Headphones();
        private List <Headphones> list = new ArrayList();
        
        @Cacheable("headphoneslist")	
	public void listHeadphones() {
		list = this.headphonesDAO.listHeadphones();
                Collections.sort(list, this.COMPARE_BY_PRICE);
	}
        
        Comparator<Headphones> COMPARE_BY_PRICE = new Comparator<Headphones>(){
            @Override
            public int compare(Headphones lhs, Headphones rhs) {
                return lhs.getProduct().getPrice()- rhs.getProduct().getPrice();
            }
        };
       
        
        public List<String> image () {
                Images g = new Images();
                List <String> pics = g.getImages( "headphones", headphones.getProduct().getId());   
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
//            System.out.println(this.camera.getBrand()+"-----");
//            list = this.cameraDAO.listCamerasByBrand(this.camera.getBrand());
//		
//	}
        
        public void getHeadphonesById() {
                headphones = this.headphonesDAO.getHeadphonesById(this.headphones.getId());
               
	}
//        public List<Camera> listCamerasbyPrice() {
//		return this.cameraDAO.listCamerasbyPrice();
//	}
}
