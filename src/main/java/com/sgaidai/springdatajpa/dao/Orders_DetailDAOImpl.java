package com.sgaidai.springdatajpa.dao;


import com.sgaidai.security.entities.model.product.Orders_Detail;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Named
@Service
@Repository
@RequestScoped
public class Orders_DetailDAOImpl implements Orders_DetailDAO {
    
        @Autowired
	private EntityManager em;
        
        
        @Transactional
        @Override
	public void addOrder_Detail(List <Orders_Detail> list) { 
            int i = 0;
            for (Orders_Detail od: list){
                this.em.persist(od);
                if(++i % 10 == 0) {
                    em.flush();
                }
            }
            em.flush();
	}
        
     
   
}