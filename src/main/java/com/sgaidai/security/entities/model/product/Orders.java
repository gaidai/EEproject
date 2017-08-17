/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.security.entities.model.product;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@ManagedBean(name="orders")
@Table(name="orders")
@Entity
public class Orders implements Serializable {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="buyer_id")
    private int buyer_id;
        
    @Column(name="total")
    private int total; 
    
    @OneToMany(mappedBy = "order_id",fetch = FetchType.EAGER)     
    private List<Order_detail> order_details;
    
    public List<Order_detail> getOrder_details() {
        return order_details;
    }

    public void setOrder_details(List<Order_detail> order_details) {
        this.order_details = order_details;
    }
    
  
    
}
