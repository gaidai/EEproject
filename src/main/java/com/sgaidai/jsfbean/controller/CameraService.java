package com.sgaidai.jsfbean.controller;


import com.sgaidai.security.entities.model.product.Camera;
import com.sgaidai.springdatajpa.dao.CameraDAO;
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
@ManagedBean(name="cameraService")
@ViewScoped
public class CameraService implements Serializable{        
        
	@Autowired
	private CameraDAO cameraDAO;
        private Camera camera = new Camera();
        private List <Camera> list = new ArrayList();
        private List <Camera> fulllist = new ArrayList();
        // Rannge for the price slider
        private int max = 50000;
        private int min = 100;
        @Cacheable(value="itemlist", key="#name")
	public void listCameras(String name) {
		fulllist = this.cameraDAO.listCameras();
                list = fulllist;
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
        
        public void getcamerabyid() {
            this.camera = this.cameraDAO.getcamerabyid( this.camera.getId());
               
	}
        public void onSlideEnd() {
            this.list = new ArrayList();
            int price;
            for(Camera h: fulllist ){
                price = h.getProduct().getPrice();
                if(price <= max && price>= min  ){         
                     list.add(h);
                }
            } 
        }
}
