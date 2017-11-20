
package com.sgaidai.springdatajpa.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.sgaidai.security.entities.model.product.Product;
import java.util.List;
import javax.inject.Named;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;


@Named
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-database-test.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class,TransactionalTestExecutionListener.class })
public class ProductDAOImplTest {    
    
    @Autowired
    private ProductDAO productDAO;

    	@Test
        @DatabaseSetup("/sampleData.xml")
	public void testGetProductbyid() throws Exception {
		Product p = this.productDAO.getProductbyid(1);
                System.out.println(p);
                	assertEquals("1100D", p.getModel());
	}
        
     	@Test
        @DatabaseSetup("/sampleData.xml")       
        public void testListProductsbyPrice(){
            List<Product> all = this.productDAO.listProductsbyPrice();
            all.forEach((p) -> {
                System.out.println(p);
        });
            assertEquals(2, all.size());
        }
    
}
