/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.servlet.listener;

import com.sun.faces.facelets.util.Path;
import com.supinfo.supcourses.entity.Course;
import com.supinfo.supcourses.entity.Role;
import com.supinfo.supcourses.entity.User;
import com.supinfo.supcourses.service.CourseService;
import com.supinfo.supcourses.service.RoleService;
import com.supinfo.supcourses.service.UserService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;
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
    
    @EJB
    private CourseService courseService;
    
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
        if(courseService.getAllCourses().isEmpty()){
            String relativeWebPath = "/resources/txt/1.txt";
            String absoluteDiskPath = sce.getServletContext().getRealPath(relativeWebPath);
            java.nio.file.Path path = Paths.get(absoluteDiskPath);
            try {
                String content = Files.lines(path, StandardCharsets.UTF_8).collect(joining(" "));
                Course course = new Course();
                course.setTitle("Comment extraire des données d’un fichier audio ?");
                course.setContent(content);
                courseService.addCourse(course);
              
            } catch (IOException ex) {
                Logger.getLogger(SupCoursesServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
