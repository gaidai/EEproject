package com.sgaidai.security.entities.model.product;


import com.sgaidai.security.entities.model.User;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    @ManyToOne(  fetch = FetchType.EAGER )
    @JoinColumn(name="userId")
    private User userId;
    
        
    @Column(name="total")
    private int total; 
    
    @Column(name="phone")
    private int phone; 
    
    @Column(name="firstname")
    private String firstname; 
    
    @Column(name="lastname")
    private String lastname; 
    
    @Column(name="delivery")
    private String delivery; 
    
    @Column(name="status")
    private String status; 
    
    @Column(name="description")
    private String description; 
     
    @Column(name="adress")
    private String adress; 
    
    @OneToMany(mappedBy = "order_id",fetch = FetchType.EAGER)     
    private List<Orders_Detail> order_details;
    
}
