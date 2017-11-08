package com.sgaidai.jsfbean.controller;


import com.sgaidai.secondary.Growl;
import com.sgaidai.security.entities.model.product.Mistake;
import com.sgaidai.security.entities.model.product.Product;
import com.sgaidai.security.entities.model.product.Review;
import com.sgaidai.springdatajpa.dao.ProductDAO;
import com.sgaidai.springdatajpa.dao.SupportDAO;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
@Named 
@ManagedBean(name="supportService")
@ViewScoped
public class SupportService implements Serializable{
       
   
	@Autowired
	private SupportDAO supportDAO;
        @Autowired
        private ProductDAO productDAO;
        private Review review = new Review();
        private Mistake mistake = new Mistake();
        private int stars;
        
    
	public String addMistake() {
            try{ 
                this.supportDAO.addMistake(this.mistake);
                
            }catch(Exception e){
                
                System.out.println("new Mistake notification is not added, Exception !!!"  );
                e.printStackTrace();
               return null;
            }
            mistake = new Mistake();
            return "thanks.xhtml";
	}
        public void addToWishList() {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String,String> params = fc.getExternalContext().getRequestParameterMap();	
            int product_id = Integer.parseInt(params.get("wish_product_id"));
            Product item = this.productDAO.getProductbyid(product_id);
            HashSet <Product> wishlist = new HashSet();             
            wishlist.addAll(UserBean.log.getFavorite());
            Growl growl = new Growl();
            if( !wishlist.contains(item)){
                wishlist.add(item);
                UserBean.log.setFavorite(wishlist);
                this.supportDAO.addToWishList(item);
                
                growl.saveMessage("The Product has added to wishlist !!!");
            }else{
                growl.saveMessage("The Product was added to wishlist before !!!");
            }
	}
        public void deletFromWishList(Product p) {
            this.supportDAO.deletFromWishList(p);
	}
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
                stars = 0;
            }catch(Exception e){
                System.out.println("new Review is not added, Exception !!!"  );
                e.printStackTrace();               
            }
	}
 
        
        
}
