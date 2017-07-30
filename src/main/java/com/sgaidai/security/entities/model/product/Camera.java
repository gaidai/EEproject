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
@ManagedBean(name="camera")
@Table(name="camera")
@Entity
public class Camera implements Serializable {

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
    
    @Column(name="resolution")
    private int resolution;
        
    @Column(name="brand")
    private String brand ;
          
    @Column(name="color")
    private String color ;
    
    @Column(name="description")
    private String desc ;
	
}
