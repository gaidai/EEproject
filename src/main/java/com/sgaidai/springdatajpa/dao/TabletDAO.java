/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.springdatajpa.dao;

import com.sgaidai.security.entities.model.product.Tablet;
import java.util.List;
import javax.inject.Named;


@Named
public interface TabletDAO {
    
    public void addTablet(Tablet t) ;      
       
    public List<Tablet> listTablets();
//    
//     public List<Camera> listCamerasbyPrice();
//               
//    public void deleteCamera(Camera c);
//    
//    public List<Camera> listCamerasByBrand(String b);
    
    public Tablet getTabletById(int id) ;
    
}
