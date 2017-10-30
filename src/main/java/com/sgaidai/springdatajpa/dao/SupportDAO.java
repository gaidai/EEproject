/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.springdatajpa.dao;

import com.sgaidai.security.entities.model.product.Mistake;
import com.sgaidai.security.entities.model.product.Product;
import javax.inject.Named;


@Named
public interface SupportDAO {
    
    void addMistake(Mistake m) ; 
    void addToWishList(Product p) ;  
//       
//    public List<Camera> listCameras();
//    
//     public List<Camera> listCamerasbyPrice();
//               
//    public void deleteCamera(Camera c);
//    
//    public List<Camera> listCamerasByBrand(String b);
//    
//    public Camera getcamerabyid(int id) ;
    
}
