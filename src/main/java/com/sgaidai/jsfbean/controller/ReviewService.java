package com.sgaidai.jsfbean.controller;


import com.sgaidai.secondary.Growl;
import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.security.entities.model.product.Review;
import com.sgaidai.springdatajpa.dao.SupportDAO;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
@Named 
@ManagedBean(name="reviewService")
@RequestScoped 
public class ReviewService implements Serializable{        
        
    
	@Autowired
	private SupportDAO supportDAO;
        private Review review = new Review();
        private int stars;

    
	public void addReview(Product p) {
            try{ 
                this.review.setProduct(p);
                this.review.setEnabled(true);
                if(stars>0){
                    this.review.setRating(stars);  
                }
                this.supportDAO.addReview(this.review);
                System.out.println("added new Review !!!");
                this.review = new Review();
                Growl growl = new Growl();
                growl.saveMessage("Review will be added soon !!!");
            }catch(Exception e){
                System.out.println("new Review is not added, Exception !!!"  );
                e.printStackTrace();
               
            }
	}
 
}
