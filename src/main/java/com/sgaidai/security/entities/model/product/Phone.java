/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.security.entities.model.product;

import java.io.Serializable;
import javax.inject.Named;
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
@Named
@Table(name="phone")
@Entity
public class Phone  extends AbstractProductEntity implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
        
    @Column(name="os")
    private String os;
    
    @Column(name="diagonal")
    private String diagonal;
    
    @Column(name="simcount")
    private int simcount;
    
    @Column(name="ram")
    private String ram;
    
    @Column(name="rom")
    private String rom;
    
    @Column(name="cores")
    private int cores;
    
    @Column(name="cpu")
    private String cpu ;
     
    @Column(name="simtype")
    private String simtype ;
    
    @Column(name="resolution")
    private String resolution ;
  	
}
