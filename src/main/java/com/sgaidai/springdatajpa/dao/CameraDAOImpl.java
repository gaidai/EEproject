package com.sgaidai.springdatajpa.dao;



import com.sgaidai.security.entities.model.product.Camera;
import java.util.List;
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
	public List<Camera> listCamerasbyPrice() {
		return this.em.createQuery("SELECT c FROM Camera c ORDER BY c.price").getResultList();
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
            System.out.println(b +"*************");
            return this.em.createQuery("SELECT c FROM Camera c WHERE c.brand ="+b).getResultList();
            
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

        
        @Transactional 
        @Override
        public Camera getcamerabyid(int id){
            
            Camera result =(Camera) this.em.createQuery("SELECT c FROM Camera c WHERE c.product.id ="+id).getSingleResult();            
            return result;
        }        
}