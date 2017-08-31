package com.sgaidai.jsfbean.controller;


import com.sgaidai.security.entities.model.product.Mistake;
import com.sgaidai.springdatajpa.dao.SupportDAO;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
@Named 
@ManagedBean(name="supportService")
@RequestScoped 
public class SupportService implements Serializable{        
        
    
	@Autowired
	private SupportDAO supportDAO;
        private Mistake mistake = new Mistake();
        private int stars;

    
	public void addMistake() {
            try{ 
                this.supportDAO.addMistake(this.mistake);
                
            }catch(Exception e){
                
                System.out.println("new Mistake notification is not added, Exception !!!"  );
                e.printStackTrace();
               
            }
	}
 
}
