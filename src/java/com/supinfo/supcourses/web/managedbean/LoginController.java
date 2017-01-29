/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.managedbean;

import com.supinfo.supcourses.entity.User;
import com.supinfo.supcourses.service.UserService;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "Login")
@SessionScoped
public class LoginController implements Serializable {
    
    private User user;
    
    private String password;
    
    private String email;
    
    private String message;
    
    @EJB
    private UserService userService;
    
    public String login(){
        User loggedUser = userService.authentify(this.email, this.password);
        if( loggedUser != null){
            user = loggedUser;
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            sessionMap.put("user", user);
            return "/private/index?faces-redirect=true";
        } 
        user = new User();
        setMessage("invalid password or email.");
        return "";
    }
    
    public User getUser() {
        return user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
