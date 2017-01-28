/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao;

import com.supinfo.supcourses.entity.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gery
 */
@Local
public interface UserDao {
    User addUser(User user);
    
    List<User> getAllUsers();
    
    User findUserById(Long userId);
    
    void removeUser(User user);   
    
}
