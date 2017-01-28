/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.managedbean;

import com.supinfo.supcourses.entity.User;
import com.supinfo.supcourses.service.UserService;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "Subscribe")
@ViewScoped
public class SubscribeController implements Serializable {
    
    private User user;
    
    @EJB
    private UserService userService;
    
    @PostConstruct
    public void init() { 
        if(user == null){
            user = new User();
        }
    }
    
    public void submit() {
        userService.addUser(user);
    }
    
     public User getUser() {
        return user;
    }
    
}
