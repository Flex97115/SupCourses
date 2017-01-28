/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.service;

import com.supinfo.supcourses.dao.RoleDao;
import com.supinfo.supcourses.entity.Role;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Gery
 */
@Stateless
public class RoleService {
    
    @EJB
    private RoleDao roleDao;
    
    public Role addRole(Role role){
        return roleDao.addRole(role);
    }
    
    public List<Role> getAllRoles(){
        return roleDao.getAllRoles();
    }
    
    public Role getAdminRole(){
        return roleDao.getAdminRole();
    }
    
    public Role getStudentRole(){
        return roleDao.getStudentRole();
    }
    
    public Role getWriterRole(){
        return roleDao.getWriterRole();
    }
}
