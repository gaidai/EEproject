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
@Named
@Table(name="headphones")
@Entity
public class Headphones implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product ;  
        
    @Column(name="mic")
    private boolean mic;    
    
    @Column(name="wireless")
    private boolean wireless;   
    
    @Column(name="type")
    private String type ;
        
    @Column(name="description")
    private String desc ;
    
//    public static final Comparator<Headphones> COMPARE_BY_PRICE = new Comparator<Headphones>() {
//        @Override
//        public int compare(Headphones lhs, Headphones rhs) {
//            return lhs.getProduct().getPrice()- rhs.getProduct().getPrice();
//        }
//    };
	
}
