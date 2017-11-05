package com.sgaidai.springdatajpa.dao;



import com.sgaidai.jsfbean.controller.UserBean;
import com.sgaidai.security.entities.model.product.Mistake;
import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.security.entities.model.product.Review;
import java.util.HashSet;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service
@Repository
@ViewScoped
public class SupportDAOImpl implements SupportDAO {
    
        @Autowired
	private EntityManager em;
        
        @Transactional
        @Override
	public void addMistake(Mistake m) {
		this.em.persist(m);
	}
        
        @Transactional
        @Override
	public void addToWishList(Product p) {
            this.em.merge(UserBean.log);  
	}     
        
        @Transactional
        @Override
	public void deletFromWishList(Product p) {
            HashSet <Product> wishlist =   new HashSet();             
            wishlist.addAll(UserBean.log.getFavorite());
            wishlist.remove(p);
            if( !wishlist.contains(p)){
                UserBean.log.setFavorite(wishlist);
                this.em.merge(UserBean.log);
            }
            
	}  
        @Transactional
        @Override
	public void addReview(Review o) {
            this.em.persist(o); 
            em.flush();
	}
    
}