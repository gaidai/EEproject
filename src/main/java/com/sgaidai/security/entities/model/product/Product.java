
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
@ManagedBean(name="product")
@Table(name="product")
@Entity
public class Product implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="category")
    private String category ;
    
    @Column(name="model")
    private String model ;
    
    @Column(name="price")
    private int price;
    
    @Column(name="quantity")
    private int  quantity ;       
        
    @Column(name="brand")
    private String brand ;
          
    @Column(name="color")
    private String color ;
    
    @Column(name="description")
    private String description ;
	
}
