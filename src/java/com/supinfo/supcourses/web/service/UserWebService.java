/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.service;

import com.supinfo.supcourses.entity.User;
import com.supinfo.supcourses.service.UserService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Gery
 */
@WebService(serviceName = "UserWebService")
public class UserWebService {
    @EJB
    private UserService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addUser")
    public User addUser(@WebParam(name = "user") User user) {
        return ejbRef.addUser(user);
    }

    @WebMethod(operationName = "getAllUsers")
    public List<User> getAllUsers() {
        return ejbRef.getAllUsers();
    }

    @WebMethod(operationName = "findUserById")
    public User findUserById(@WebParam(name = "userId") Long userId) {
        return ejbRef.findUserById(userId);
    }

    @WebMethod(operationName = "removeUser")
    @Oneway
    public void removeUser(@WebParam(name = "user") User user) {
        ejbRef.removeUser(user);
    }

    @WebMethod(operationName = "findUserByMail")
    public User findUserByMail(@WebParam(name = "mail") String mail) {
        return ejbRef.findUserByMail(mail);
    }

    @WebMethod(operationName = "authentify")
    public User authentify(@WebParam(name = "mail") String mail, @WebParam(name = "password") String password) {
        return ejbRef.authentify(mail, password);
    }

    @WebMethod(operationName = "updateUser")
    public User updateUser(@WebParam(name = "user") User user) {
        return ejbRef.updateUser(user);
    }
    
}
