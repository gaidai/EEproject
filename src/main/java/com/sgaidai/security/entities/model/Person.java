package com.sgaidai.security.entities.model;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Named 
@ManagedBean(name="person")
@SessionScoped
@Table(name="Person")
@Entity
public class Person implements Serializable {

	@Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
        private String country;
	
}
