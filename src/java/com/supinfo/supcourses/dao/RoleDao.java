/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao;

import com.supinfo.supcourses.entity.Role;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gery
 */
@Local
public interface RoleDao {
    
    Role addRole(Role role);
    
    List<Role> getAllRoles();
    
    Role getAdminRole();
    
    Role getStudentRole();

    Role getWriterRole();
}
