package com.sgaidai.springdatajpa.dao;



import com.sgaidai.security.entities.model.product.Tablet;
import com.sgaidai.security.entities.model.product.Tablet_;
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
public class TabletDAOImpl implements TabletDAO {
    
        @Autowired
	private EntityManager em;
        
        @Transactional
        @Override
	public void addTablet(Tablet c) {
		this.em.persist(c);
	}
        
        @Transactional 
        @Override
	public List<Tablet> listTablets() {
		return this.em.createQuery("SELECT c FROM Tablet c").getResultList();
	}
       
        @Transactional 
        @Override
        public Tablet getTabletById(int id){
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Tablet> criteriaQuery = cb.createQuery(Tablet.class);
            Root<Tablet> tabletEntityRoot = criteriaQuery.from(Tablet.class);

            criteriaQuery.select(tabletEntityRoot).distinct(true);
//        }

//            Predicate criteria = cb.conjunction();
//            Predicate p = cb.equal(cameraEntityRoot.get(Camera_.brand), b);
//            criteria = cb.and(criteria, p);

            criteriaQuery.where(cb.equal(tabletEntityRoot.get(Tablet_.product), id));
            Tablet result = em.createQuery(criteriaQuery).getSingleResult();
            
            return result;
        }
        
}