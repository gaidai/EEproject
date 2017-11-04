package com.sgaidai.springdatajpa.dao;




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
public class OrdersDAOImpl implements OrdersDAO {
    
        @Autowired
	private EntityManager em;
        
        @Transactional
        @Override
	public Orders addOrder(Orders o) {
            Orders del = o;
	    del = em.merge(del);
            this.em.persist(del);
            em.flush();
            return del;
	}
        
        @Transactional 
        @Override
	 public List<Orders> listAllOrders() { 
            List<Orders> result = this.em.createQuery("SELECT o FROM Orders o").getResultList();            
            return result;
	}
        
        @Transactional
        @Override
        public void deleteOrder(Orders o) {
            Orders del = o;
	    del = em.merge(del);
            this.em.remove(del);

	}
        
        @Transactional 
        @Override
        public Orders getOrderById(int id){
            Orders result = em.find(Orders.class, id);            
            return result;
        }
        
        @Transactional
        @Override
        public List<Orders> listOrdersByBuyerId(int userId) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Orders> criteriaQuery = cb.createQuery(Orders.class);
            Root<Orders> orderEntityRoot = criteriaQuery.from(Orders.class);

            criteriaQuery.select(orderEntityRoot).distinct(true);
            criteriaQuery.where(cb.equal(orderEntityRoot.get("userId"), userId));
            List<Orders> result =  em.createQuery(criteriaQuery).getResultList();
            
            return result;
            
        }
}