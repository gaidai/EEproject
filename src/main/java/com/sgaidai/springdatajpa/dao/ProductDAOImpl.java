package com.sgaidai.springdatajpa.dao;


import com.sgaidai.security.entities.model.product.Product;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
@Named
@Service
@Repository
public class ProductDAOImpl implements ProductDAO {
    
        @Autowired
	private EntityManager em;
        
        @Transactional
        @Override
	public void addProduct(Product p) {
		this.em.persist(p);
	}
        
        @Transactional 
        @Override
        public List<Product> getTop(String top){
            List<Product>  result ;
            result = this.em.createQuery("SELECT p FROM Product p WHERE p.description ='"+top+"'").getResultList();
            return result;
        }
        
        @Transactional 
        @Override
	public List<Product> listProductsByCategory(String category) {
		return this.em.createQuery("SELECT p FROM Product p WHERE p.brand ="+category).getResultList();
	}
        
        @Transactional 
        @Override
	public List<Product> listProductsbyPrice() {
		return this.em.createQuery("SELECT p FROM Product p ORDER BY p.price").getResultList();
	}
        
        @Transactional
        @Override
        public void deleteProduct(Product p  ) {
            Product del = p;
	    del = em.merge(del);
            this.em.remove(del);

	}
        
        @Transactional 
        @Override
        public List<Product> listProductsByBrand(String b){
            System.out.println(b +"*************");
            return this.em.createQuery("SELECT p FROM Product p WHERE p.brand ="+b).getResultList();
            
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Camera> criteriaQuery = cb.createQuery(Camera.class);
//            Root<Camera> cameraEntityRoot = criteriaQuery.from(Camera.class);
//
//            criteriaQuery.select(cameraEntityRoot).distinct(true);
////        }
//
////            Predicate criteria = cb.conjunction();
////            Predicate p = cb.equal(cameraEntityRoot.get(Camera_.brand), b);
////            criteria = cb.and(criteria, p);
//
//            criteriaQuery.where(cb.equal(cameraEntityRoot.get(Camera_.brand), b));
//            List<Camera> result = em.createQuery(criteriaQuery).getResultList();
//            for(Camera r: result){
//                System.out.println(r.getId() + " "+ r.getModel());
//            }
//            return result;
        }
//        @Transactional 
//        public List<Camera> listCamerasByPrice(String b){
//            
//            System.out.println(b +"*************");
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Camera> criteriaQuery = cb.createQuery(Camera.class);
//            Root<Camera> cameraEntityRoot = criteriaQuery.from(Camera.class);
//            
//        
//            
//            criteriaQuery.select(cameraEntityRoot).distinct(true).orderBy(cb.asc(cameraEntityRoot.get("price")));
////        }
//
////            Predicate criteria = cb.conjunction();
////            Predicate p = cb.equal(cameraEntityRoot.get(Camera_.brand), b);
////            criteria = cb.and(criteria, p);
//
//            criteriaQuery.where(cb.equal(cameraEntityRoot.get("brand"), b));
//            List<Camera> result = em.createQuery(criteriaQuery).getResultList();
//            for(Camera r: result){
//                System.out.println(r);
//            }
//            return result;
//        }
        
        @Transactional 
        @Override
        public Product getProductbyid(int id){            
            Product result = this.em.find(Product.class, id);          
                   
            return result;
        }
        
}