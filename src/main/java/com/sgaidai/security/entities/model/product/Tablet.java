/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.security.entities.model.product;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@ManagedBean(name="tablet")
@Table(name="tablet")
@Entity
public class Tablet implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product ;  
    
    @Column(name="os")
    private String os; 
    
    @Column(name="cores")
    private int cores; 
    
    @Column(name="resolution")
    private String resolution; 
    
    @Column(name="diagonal")
    private String diagonal;      
        
    @Column(name="description")
    private String desc ;
	
}
