package com.sgaidai.springdatajpa.dao;




import com.sgaidai.security.entities.model.product.Orders;
import com.sgaidai.security.entities.model.product.Review;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service
@Repository
@RequestScoped
public class ReviewDAOImpl implements ReviewDAO {
    
        @Autowired
	private EntityManager em;
        
        @Transactional
        @Override
	public void addReview(Review o) {
            this.em.persist(o); 
            em.flush();
	}
        
         
       
}