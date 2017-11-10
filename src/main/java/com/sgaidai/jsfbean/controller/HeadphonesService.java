package com.sgaidai.jsfbean.controller;


import com.sgaidai.security.entities.model.product.Headphones;
import com.sgaidai.springdatajpa.dao.HeadphonesDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SlideEndEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;


@Getter
@Setter
@Named 
@ManagedBean(name="headphonesService")
@RequestScoped
public class HeadphonesService implements Serializable {
        
        
    @Autowired
    private HeadphonesDAO headphonesDAO;
    private Headphones headphones = new Headphones();
    private List <Headphones> list = new ArrayList();
    private List <Headphones> fulllist = new ArrayList();
    // Rannge for the price slider
    private int max = 30000;
    private int min = 100;

    @Cacheable(value="itemlist", key="#name")
    public void listHeadphones(String name) {
        fulllist = this.headphonesDAO.listHeadphones();                
        Collections.sort(fulllist, this.COMPARE_BY_PRICE);
        list = fulllist;
       
    }

    Comparator<Headphones> COMPARE_BY_PRICE = new Comparator<Headphones>(){
        @Override
        public int compare(Headphones lhs, Headphones rhs) {
            return lhs.getProduct().getPrice()- rhs.getProduct().getPrice();
        }
    };


    public void getHeadphonesById() {
        headphones = this.headphonesDAO.getHeadphonesById(this.headphones.getId());

    }
    public void onSlideEnd() {
        System.out.println(min + " onSlideEnd ");
        System.out.println( max);
        System.out.println(fulllist.size());
        System.out.println(list.size());
        this.list = new ArrayList();
        int price;
        for(Headphones h: fulllist ){
            price = h.getProduct().getPrice();
            if(price <= max && price>= min  ){         
                 list.add(h);
            }
        } 
        System.out.println(list.size());
        System.out.println(fulllist.size());
    }    
}
