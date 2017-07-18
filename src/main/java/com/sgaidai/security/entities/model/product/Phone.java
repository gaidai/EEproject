/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.security.entities.model.product;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ManagedBean(name="phone")
@Table(name="phone")
@Entity
public class Phone implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="model")
    private String model ;
    
    @Column(name="price")
    private int price;
    
    @Column(name="count")
    private int count;
    
    @Column(name="camera")
    private int camera;
    
    @Column(name="simcount")
    private int simcount;
    
    @Column(name="ram")
    private int ram;
    
    @Column(name="rom")
    private int rom;
    
    @Column(name="brand")
    private String brand ;
     
    @Column(name="simtype")
    private String simtype ;
      
    @Column(name="color")
    private String color ;
    
       
    
    
    
    
	
}
