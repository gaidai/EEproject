package com.sgaidai.jsfbean.controller;

import com.sgaidai.secondary.Images;
import com.sgaidai.security.entities.model.product.Tablet;
import com.sgaidai.springdatajpa.dao.TabletDAO;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean(name="tabletService")
@SessionScoped
public class TabletService implements Serializable{
        
        
	@Autowired
	private TabletDAO tabletDAO;
        private Tablet tablet = new Tablet();
        private List <Tablet> list = new ArrayList();
        
        @Cacheable("tabletlist")
	public void listTablets() {
		list = this.tabletDAO.listTablets();
	}
        
        public List<String> image () {
                Images g = new Images();
               System.out.println( tablet.getProduct().getId() );
                List <String> pics = g.getImages( "tablets", tablet.getProduct().getId());   
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
        
        public void getTabletbyid() {
                tablet = this.tabletDAO.getTabletById(this.tablet.getId());
               
	}
//        public List<Camera> listCamerasbyPrice() {
//		return this.cameraDAO.listCamerasbyPrice();
//	}
}
