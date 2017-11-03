/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.secondary;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;

/**
 *
 * @author user
 */
public class ImagesTest {
    
    
    @InjectMocks  
    Images instance= new Images();

    @Test
    public void testGetImages() {
        String category = "test";
        int id = 1;
                
        List<String> expResult = new ArrayList();
        expResult.add("test1.png");
        expResult.add("test2.png");        
        List<String> result = instance.getImages(category, id);
        assertEquals(expResult, result);
        System.out.println(expResult);
        System.out.println(result);
//        fail("The test case is a prototype.");
    }

    
}
