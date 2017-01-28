/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.servlet;

import com.supinfo.supcourses.entity.Role;
import com.supinfo.supcourses.entity.User;
import com.supinfo.supcourses.service.RoleService;
import com.supinfo.supcourses.service.UserService;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Gery
 */
public class SupCoursesServletContextListener implements ServletContextListener {

    @EJB
    private UserService userService;
    
    @EJB
    private RoleService roleService;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if(roleService.getAllRoles().isEmpty()){
            Role adminRole = new Role();
            adminRole.setMachineName(Role.RoleEnum.ADMIN);
            adminRole.setReadableName(Role.RoleEnum.ADMIN.getName());
            roleService.addRole(adminRole);
            
            Role writerRole = new Role();
            writerRole.setMachineName(Role.RoleEnum.WRITER);
            writerRole.setReadableName(Role.RoleEnum.WRITER.getName());
            roleService.addRole(writerRole);
            
            Role studentRole = new Role();
            studentRole.setMachineName(Role.RoleEnum.STUDENT);
            studentRole.setReadableName(Role.RoleEnum.STUDENT.getName());
            roleService.addRole(studentRole);
            
        }
        if(userService.getAllUsers().isEmpty()){
            User admin = new User();
            admin.setEmail("admin@supinfo.com");
            admin.setFirstName("admin");
            admin.setLastName("admin");
            admin.setPassword("admin");
            admin.setRole(roleService.getAdminRole());
            userService.addUser(admin);
            
            User student = new User();
            student.setEmail("student@supinfo.com");
            student.setFirstName("student");
            student.setLastName("student");
            student.setPassword("student");
            student.setRole(roleService.getStudentRole());
            userService.addUser(student);
            
            User writer = new User();
            writer.setEmail("writer@supinfo.com");
            writer.setFirstName("writer");
            writer.setLastName("writer");
            writer.setPassword("writer");
            writer.setRole(roleService.getWriterRole());
            userService.addUser(writer);
        }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
