package com.sgaidai.springdatajpa.dao;




import com.sgaidai.security.entities.model.product.Order_Detail;
import com.sgaidai.security.entities.model.product.Orders;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service
@Repository
@RequestScoped
public class Order_DetailDAOImpl implements Order_DetailDAO {
    
        @Autowired
	private EntityManager em;
        
        
        @Transactional
        @Override
	public void addOrder_Detail(List <Order_Detail> list) { 
            int i = 0;
            for (Order_Detail od: list){
                this.em.persist(od);
                if(++i % 10 == 0) {
                    em.flush();
                }
            }
            em.flush();
	}
        
     
   
}