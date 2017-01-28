/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.service;

import com.supinfo.supcourses.dao.UserDao;
import com.supinfo.supcourses.entity.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Gery
 */
@Stateless
public class UserService {

    @EJB
    private UserDao userDao;

    public User addUser(User user){
        return userDao.addUser(user);
    }
    
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    
    public User findUserById(Long userId){
        return userDao.findUserById(userId);
    }
    
    public void removeUser(User user){
        userDao.removeUser(user);
    }
    
}
