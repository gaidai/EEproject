/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.jsfbean.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Images {
//
    public List<String> init(int id, String c){
        List<String> images = new ArrayList(); 
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("products/"+c+"/"+id).getFile());
        File[] files = file.listFiles();
        for(File f: files){
            if(f.isFile()){
                images.add(f.getName());
                System.out.println(f.getName());
            }
        }

        return  images;

    }
    
}
