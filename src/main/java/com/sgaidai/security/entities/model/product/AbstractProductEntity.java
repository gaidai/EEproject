
package com.sgaidai.security.entities.model.product;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * Timestamp being applied to tables
 */

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class AbstractProductEntity {
      
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product ;     
  
    @Column(name="description")
    private String description ;
      
       
}
