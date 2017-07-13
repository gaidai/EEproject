package com.sgaidai.security.entities.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @RRay
 */
@Entity        
@Table(name="role"
    ,catalog="testing",uniqueConstraints = @UniqueConstraint(
		columnNames = { "user_id", "role" })        
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role  implements java.io.Serializable {

    

    @Id 
    @Column(name="role_id", unique=true, nullable=false)
    private int roleId;  
    
    @Column(name="role", nullable=false, length=45)
    private String role;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;

   
    

   

  

@Override
    public String toString() {
    return "Role is:-"
    + "\n\t RoleId:- " + this.getRoleId()
    + "\n\t UserId:- " + this.getUser().getUserId()
    + "\n\t Role:- " + this.role;
    }

}