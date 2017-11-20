package com.sgaidai.security.entities.model.product;


import com.sgaidai.security.entities.model.User;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Named;
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
@Named
@Table(name="orders")
@Entity
public class Orders extends AbstractTimestampCreateEntity implements Serializable {
    
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
    private String phone; 
    
    @Column(name="payment_method")
    private String payment_method;         
    
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
    
    @Column(name="city")
    private String city;
    
    @OneToMany(mappedBy = "order_id",fetch = FetchType.EAGER)     
    private Set<Orders_Detail> order_details = new HashSet();
    
}
