package com.sgaidai.springdatajpa.dao;



import com.sgaidai.security.entities.model.product.Phone;
import com.sgaidai.security.entities.model.product.Phone_;
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
public class PhoneDAOImpl implements PhoneDAO {
    
        @Autowired
	private EntityManager em;
        
        @Transactional
        @Override
	public void addPhone(Phone p) {
		this.em.persist(p);
	}
        
        @Transactional 
        @Override
	public List<Phone> listPhones() {
		return this.em.createQuery("SELECT c FROM Phone c").getResultList();
	}
        
        @Transactional
        @Override
        public void deletePhone(Phone p) {
            Phone del = p;
	    del = em.merge(del);
            this.em.remove(del);

	}
        
        @Transactional 
        @Override
        public Phone getPhoneById(int id){
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Phone> criteriaQuery = cb.createQuery(Phone.class);
            Root<Phone> phoneEntityRoot = criteriaQuery.from(Phone.class);

            criteriaQuery.select(phoneEntityRoot).distinct(true);
//        }

//            Predicate criteria = cb.conjunction();
//            Predicate p = cb.equal(cameraEntityRoot.get(Camera_.brand), b);
//            criteria = cb.and(criteria, p);

            criteriaQuery.where(cb.equal(phoneEntityRoot.get(Phone_.product), id));
            Phone result = em.createQuery(criteriaQuery).getSingleResult();
            
            return result;
        }
}