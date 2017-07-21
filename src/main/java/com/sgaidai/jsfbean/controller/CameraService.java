package com.sgaidai.jsfbean.controller;


import com.sgaidai.security.entities.model.product.Camera;
import com.sgaidai.springdatajpa.dao.CameraDAO;
import java.io.Serializable;
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
@ManagedBean(name="cameraService")
@SessionScoped
public class CameraService implements Serializable{
        
        
	@Autowired
	private CameraDAO cameraDAO;
        private Camera camera = new Camera();
        	
	public List<Camera> listCameras() {
		return this.cameraDAO.listCameras();
	}
       
	public void addCamera(Camera c) {
		this.cameraDAO.addCamera(c);
	}
        
	public void deleteCamera(Camera c) {
                this.cameraDAO.deleteCamera(c);
	}
        public List<Camera> listCamerasByBrand(String brand) {
		return this.cameraDAO.listCamerasByBrand(brand);
	}
        
        public void getcamerabyid() {
                camera = this.cameraDAO.getcamerabyid(this.camera.getId());
                
               
	}
}
