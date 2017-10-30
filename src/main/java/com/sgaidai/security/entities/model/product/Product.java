
package com.sgaidai.security.entities.model.product;


import com.sgaidai.security.entities.model.User;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude ={"users"}  )
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
    
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)     
    private List<Review> review;
    
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_favorite",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users;
    
    @Override public boolean equals(Object o) {
      if (o == this) return true;
      if (!(o instanceof Product)) return false;
      Product other = (Product) o;
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
