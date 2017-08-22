
package com.sgaidai.secondary;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.Serializable;


public class Images implements Serializable{

    


    
    public List<String> getImages(String category, int id){
        List<String> images = new ArrayList(); 
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("products/"+category+"/"+id).getFile());
        File[] files = file.listFiles();
        for(File f: files){
            if(f.isFile()){
                images.add(f.getName());
            }
        }
        return  images;

    }    
}
