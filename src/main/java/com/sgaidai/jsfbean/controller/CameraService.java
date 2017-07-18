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


@Named 
@ManagedBean(name="cameraService")
@SessionScoped
public class CameraService implements Serializable{
        
        @Getter
        @Setter
	@Autowired
	private CameraDAO cameraDAO;
        	
	public List<Camera> listCameras() {
		return this.cameraDAO.listCameras();
	}
       
	public void addCamera(Camera c) {
		this.cameraDAO.addCamera(c);
	}
        
	public void deleteCamera(Camera c) {
                this.cameraDAO.deleteCamera(c);
	}
}
