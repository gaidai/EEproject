package com.sgaidai.springdatajpa.dao;




import com.sgaidai.security.entities.model.product.Camera;
import com.sgaidai.security.entities.model.product.Camera_;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service
@Repository
@RequestScoped
public class CameraDAOImpl implements CameraDAO {
    
        @Autowired
	private EntityManager em;
        
        @Transactional
        @Override
	public void addCamera(Camera c) {
		this.em.persist(c);
	}
        
        @Transactional 
        @Override
	public List<Camera> listCameras() {
		return this.em.createQuery("SELECT c FROM Camera c").getResultList();
	}
        
        @Transactional
        @Override
        public void deleteCamera(Camera c  ) {
            Camera del = new Camera();
            del = c;
		del = em.merge(del);
            this.em.remove(del);

	}
        
        @Transactional 
        @Override
        public List<Camera> listCamerasByBrand(String b){
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Camera> criteriaQuery = cb.createQuery(Camera.class);
            Root<Camera> cameraEntityRoot = criteriaQuery.from(Camera.class);

            criteriaQuery.select(cameraEntityRoot).distinct(true);

            Predicate criteria = cb.conjunction();
            Predicate p = cb.equal(cameraEntityRoot.get(Camera_.brand), b);
            criteria = cb.and(criteria, p);
            criteriaQuery.where(criteria);
            List<Camera> result = em.createQuery(criteriaQuery).getResultList();
            return result;
        }
        
}