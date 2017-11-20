package com.sgaidai.jsfbean.controller;

import com.sgaidai.security.entities.model.product.Tablet;
import com.sgaidai.springdatajpa.dao.TabletDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;


@Getter
@Setter
@Named 
@ConversationScoped
public class TabletService implements Serializable{
        
        
	@Autowired
	private TabletDAO tabletDAO;
        private Tablet tablet = new Tablet();
        private List <Tablet> list = new ArrayList();
        private List <Tablet> fulllist = new ArrayList();
        // Rannge for the price slider
        private int max = 30000;
        private int min = 400;    
        
        @Cacheable(value="itemlist", key="#name")
	public void listTablets(String name) {
		fulllist = this.tabletDAO.listTablets();
                list = fulllist;
	}
        public void onSlideEnd() {
            this.list = new ArrayList();
            int price;
            for(Tablet h: fulllist ){
                price = h.getProduct().getPrice();
                if(price <= max && price>= min  ){         
                     list.add(h);
                }
            } 
        }

        
        public void getTabletbyid() {
                this.tablet = this.tabletDAO.getTabletById(this.tablet.getId());
               
	}
//        public List<Camera> listCamerasbyPrice() {
//		return this.cameraDAO.listCamerasbyPrice();
//	}
}
