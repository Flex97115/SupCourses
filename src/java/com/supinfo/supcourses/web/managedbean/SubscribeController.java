/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.managedbean;

import com.supinfo.supcourses.entity.User;
import com.supinfo.supcourses.service.RoleService;
import com.supinfo.supcourses.service.UserService;
import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.faces.view.facelets.FaceletContext;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "Subscribe")
@SessionScoped
public class SubscribeController implements Serializable {
    
    private User user;
    
    private String message;
    
    @EJB
    private UserService userService;
    
    @EJB
    private RoleService roleService;
    
    @PostConstruct
    public void init() { 
        if(user == null){
            user = new User();
        }
    }
    
    public String submit() {
        if(userService.findUserByMail(user.getEmail()) == null){
            user.setRole(roleService.getStudentRole());
            userService.addUser(user);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            Map<String, Object> sessionMap = externalContext.getSessionMap();
            sessionMap.put("user", user);
            user = new User();
            return "/private/index?faces-redirect=true";
        } else {
             setMessage("Email already exist.");
             user = new User();
             return "";
        }
    }
    
     public User getUser() {
        return user;
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
