
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
import javax.persistence.ManyToOne;
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
@ManagedBean(name="order_detail")
@Table(name="Order_detail")
@Entity
public class Order_detail implements Serializable {
    
    @Id
    @Column(name="order_detail_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne( fetch = FetchType.EAGER, cascade= {CascadeType.REFRESH})
    @JoinColumn(name="product_id")
    private Product product_id ;
    
    @ManyToOne( cascade= {CascadeType.REFRESH}, fetch = FetchType.EAGER )
    @JoinColumn(name="order_id")
    private Orders order_id ; 
  
    
    
    @Column(name="price")
    private int fixed_price;    
    
}
