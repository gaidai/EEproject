/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgaidai.secondary;

import javax.inject.Named;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Named
@EqualsAndHashCode(exclude = {"enabled","active"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckboxParam {
    
    private String name;
    // dependence by the price range
    private boolean enabled;
    //dependence by the user click 
    private boolean active;
   
}
