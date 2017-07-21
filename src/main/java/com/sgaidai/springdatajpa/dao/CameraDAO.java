/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.springdatajpa.dao;

import com.sgaidai.security.entities.model.product.Camera;
import java.util.List;
import javax.inject.Named;


@Named
public interface CameraDAO {
    
    public void addCamera(Camera c) ;      
       
    public List<Camera> listCameras();
               
    public void deleteCamera(Camera c);
    
    public List<Camera> listCamerasByBrand(String b);
    
    public Camera getcamerabyid(int id) ;
    
}
