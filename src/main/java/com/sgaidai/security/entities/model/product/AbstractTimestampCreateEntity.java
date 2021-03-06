
package com.sgaidai.security.entities.model.product;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;


/**
 * Timestamp being applied to tables
 */

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class AbstractTimestampCreateEntity {
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false)
    private Date created=new Date ();
    
       
}
