
package com.sgaidai.secondary;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Images {

    public List<String> init(int id, String c){
        List<String> images = new ArrayList(); 
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("products/"+c+"/"+id).getFile());
        File[] files = file.listFiles();
        for(File f: files){
            if(f.isFile()){
                images.add(f.getName());
            }
        }
        return  images;
    }    
}
