package com.sgaidai.jsfbean.controller;


import com.sgaidai.secondary.CheckboxParam;
import com.sgaidai.security.entities.model.product.Camera;
import com.sgaidai.springdatajpa.dao.CameraDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;


@Getter
@Setter
@Named 
@ViewScoped
public class CameraService implements Serializable{        
        
	@Autowired
	private CameraDAO cameraDAO;
        private Camera camera = new Camera();
        private List <Camera> list = new ArrayList();
        private List <Camera> fulllist = new ArrayList();
        // Rannge for the price slider      
        private int max = 30000;
        private int min = 100;
        private SortedSet <String> brandSet ;
        private List <CheckboxParam> brands ;
        
        @Cacheable(value="itemlist", key="#name")
	public void listCameras(String name) {
            fulllist = this.cameraDAO.listCameras();
            Collections.sort(fulllist, (Camera lhs, Camera rhs)
                -> lhs.getProduct().getPrice()- rhs.getProduct().getPrice());
            list = fulllist;
            brandSet  = new TreeSet();
            brands = new LinkedList();
            fulllist.forEach((Camera h) -> {brandSet.add(h.getProduct().getBrand());
            });
            brandSet.forEach((h) -> {
                CheckboxParam p = new CheckboxParam(h,true,true);
                brands.add(p); 
            });       
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
                    for(CheckboxParam p: brands){
                        if( p.isActive() && p.isEnabled() && h.getProduct().getBrand().equals(p.getName())  ){
                            list.add(h);
                        }
                    }
                }
            } 
        }
}
