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

/**
 *
 * @author Gery
 */
@ManagedBean(name = "User")
@SessionScoped
public class UserController implements Serializable {
    @EJB
    private UserService userService;
    
    private User user;

    /**
     * @return the user
     */
    public User getUser() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        return (User) sessionMap.get("user");
    }
    
    public String logout(){
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.remove("user");
        return "/public/login?faces-redirect=true";
    }
    
}
