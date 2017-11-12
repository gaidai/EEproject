package com.sgaidai.jsfbean.controller;


import com.sgaidai.secondary.CheckboxParam;
import com.sgaidai.security.entities.model.product.Headphones;
import com.sgaidai.springdatajpa.dao.HeadphonesDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
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
@ManagedBean(name="headphonesService")
@ViewScoped
public class HeadphonesService implements Serializable {
        
        
    @Autowired
    private HeadphonesDAO headphonesDAO;
    private Headphones headphones = new Headphones();
    private List <Headphones> list = new ArrayList();
    private List <Headphones> fulllist = new ArrayList();
    // Rannge for the price slider
    private int max = 30000;
    private int min = 100;
    private SortedSet <String> brandSet ;
    private List <CheckboxParam> brands ;

    @Cacheable(value="itemlist", key="#name")
    public void listHeadphones(String name) {
        fulllist = this.headphonesDAO.listHeadphones();                
        Collections.sort(fulllist, this.COMPARE_BY_PRICE);
        list = fulllist;
        brandSet  = new TreeSet();
        brands = new LinkedList();
        fulllist.forEach((Headphones h) -> {brandSet.add(h.getProduct().getBrand());
        });
        max = 30000;
        min = 100;
        
        brandSet.forEach((h) -> {
            CheckboxParam p = new CheckboxParam(h,true,true);
            brands.add(p); 
        });       
        System.out.println(brandSet);
    }

    Comparator<Headphones> COMPARE_BY_PRICE = (Headphones lhs, Headphones rhs)
            -> lhs.getProduct().getPrice()- rhs.getProduct().getPrice();


    public void getHeadphonesById() {
        headphones = this.headphonesDAO.getHeadphonesById(this.headphones.getId());

    }
    public void onSlideEnd() {
        this.list = new ArrayList();
        int price;
        for(Headphones h: fulllist ){
            price = h.getProduct().getPrice();
            if(price <= max && price>= min  ){
                for(CheckboxParam p: brands){
                    if( p.isActive() && p.isEnabled() && h.getProduct().getBrand().equals(p.getName())  ){
                        list.add(h);
                    }
                }
            }
        } System.out.println(brandSet);
        System.out.println(brands.size());
    } 
    

}
