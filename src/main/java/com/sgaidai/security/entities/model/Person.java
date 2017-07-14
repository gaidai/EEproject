package com.sgaidai.security.entities.model;

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


@AllArgsConstructor
@NoArgsConstructor
@ToString
@ManagedBean(name="person")
@Table(name="Person")
@Entity
public class Person implements Serializable {

    @Getter
    @Setter
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Getter
    @Setter
    @Column(name="name")
    private String name;
    
    @Getter
    @Setter
    @Column(name="country")
    private String country;
	
}
