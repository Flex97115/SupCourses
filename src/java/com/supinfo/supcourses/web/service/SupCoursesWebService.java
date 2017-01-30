/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.service;

import com.supinfo.supcourses.entity.Course;
import com.supinfo.supcourses.service.CourseService;
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
@WebService(serviceName = "SupCoursesWebService")
public class SupCoursesWebService {
    @EJB
    private CourseService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addCourse")
    public Course addCourse(@WebParam(name = "course") Course course) {
        return ejbRef.addCourse(course);
    }

    @WebMethod(operationName = "getAllCourses")
    public List<Course> getAllCourses() {
        return ejbRef.getAllCourses();
    }

    @WebMethod(operationName = "removeCourse")
    @Oneway
    public void removeCourse(@WebParam(name = "course") Course course) {
        ejbRef.removeCourse(course);
    }

    @WebMethod(operationName = "findCourseById")
    public Course findCourseById(@WebParam(name = "courseId") Long courseId) {
        return ejbRef.findCourseById(courseId);
    }

    @WebMethod(operationName = "updateCourse")
    public Course updateCourse(@WebParam(name = "course") Course course) {
        return ejbRef.updateCourse(course);
    }
    
}
