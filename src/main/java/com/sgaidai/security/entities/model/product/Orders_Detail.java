
package com.sgaidai.security.entities.model.product;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean(name="order_detail")
@Table(name="order_detail")
@Entity
public class Orders_Detail implements Serializable {
    
    @Id
    @Column(name="order_detail_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product_id ;
//    cascade= {CascadeType.REFRESH},
    @ManyToOne(  fetch = FetchType.EAGER )
    @JoinColumn(name="order_id")
    private Orders order_id ; 
  
    
    @Column(name="price")
    private int fixed_price;   
    
    @Override public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof Orders_Detail)) return false;
      Orders_Detail other = (Orders_Detail) o;
      if (this.id != other.id) return false;
      return true;
    }
    
    @Override public int hashCode() {
      final int PRIME = 59;
      int result = 1;
      result = (result*PRIME) + this.id;
      return result;
    }
    
}
