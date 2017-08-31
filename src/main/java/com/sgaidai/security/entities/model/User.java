package com.sgaidai.security.entities.model;

import com.sgaidai.security.entities.model.product.Orders;
import com.sgaidai.security.entities.model.product.Product;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;





@Entity       
@Table(name="user"
    ,catalog="testing",uniqueConstraints = @UniqueConstraint(
                        columnNames = {"user_name","password" })       
)
public class User  implements java.io.Serializable {
     private int userId;
     private String firstName;
     private String lastName;
     private String email;
     private String phone;
     private String username;
     private String password;
     private Boolean enabled;    
     private Set<Role> roles = new HashSet<Role>(0);
  
    @Id    
    @Column(name="user_id", unique=true, nullable=false)
    public int getUserId() {
        return this.userId;
    }   
    public void setUserId(int userId) {
        this.userId = userId;
    }   
    @Column(name="first_name", nullable=false, length=50)
    public String getFirstName() {
        return this.firstName;
    }   
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }   
    @Column(name="last_name", nullable=false, length=50)
    public String getLastName() {
        return this.lastName;
    }   
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
      @Column(name="phone", nullable=false, length=10)
    public String getPhone() {
        return this.phone;
    }   
    public void setPhone(String phone) {
        this.phone = phone;
    }
   
    @Column(name="email", nullable=false, length=50)
    public String getEmail() {
        return this.email;
    }   
    public void setEmail(String email) {
        this.email = email;
    }   
    @Column(name="user_name", nullable=false, length=50)
   public String getUsername() {
                        return this.username;
            }
   public void setUsername(String username) {
                        this.username = username;
            }
     @Column(name="enabled", nullable=false)  
    public Boolean getEnabled() {
        return true;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }   
    @Column(name="password", nullable=false, length=100)
    public String getPassword() {
        return this.password;
    }   
    public void setPassword(String password) {
        this.password = password;
    }
 @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="user")
    public Set<Role> getRoles() {
        return this.roles;
    }
    
    private Set<Product> favorite = new HashSet(0);;
    
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_favorite",
    joinColumns = @JoinColumn(name = "userId"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    public Set<Product> getFavorite() {
        return favorite;
    }
    
    public void setFavorite(Set<Product> favorite) {
        this.favorite = favorite;
    }
    
    private List<Orders> orders = new ArrayList();
    
    @OneToMany(mappedBy = "userId",fetch = FetchType.EAGER) 
    public List<Orders> getOrders() {
        return orders;
    }  
    
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
public void reset(){
        this.userId = 0;
        this.firstName ="";
        this.lastName ="";
        this.email ="";
        this.password = "";
        this.username ="";
        this.roles = null;
        this.enabled= true;       
    }   
    @Override
    public String toString() {
    return "User is :-"
    + "\n\t FirstName:- " + this.firstName
    + "\n\t LastName:- " + this.lastName 
    + "\n\t UserName:- " + this.username
    + "\n\t Email:- " + this.email          
    + "\n\t Password:- " + this.password
    +"\n\t Authority:- " + this.getRoles();
    }
} 


