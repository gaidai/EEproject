package com.sgaidai.jsfbean.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.Getter;
import lombok.Setter;
import static com.sgaidai.jsfbean.controller.UserBean.log;
import org.springframework.security.core.authority.AuthorityUtils;


@Getter
@Setter
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {
       private String username;
       private String password;
      
   
    public void login() throws ServletException, IOException { 
                
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();     
        username = context.getRequestParameterMap().get("username");
        System.out.println("Login controller username is :-" + username);
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/login");
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        
    }   
    
    
    
    public String logout() throws IOException, ServletException {
        
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/logout");
        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
        FacesContext.getCurrentInstance().responseComplete();
        username = null;
        log = null;
        System.out.println("I PRESSED logout() " + log);        
        
        return null;
    }
    
}


    
    

