/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.service;

import com.supinfo.supcourses.dao.CourseDao;
import com.supinfo.supcourses.entity.Course;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Gery
 */
@Stateless
public class CourseService {
    
    @EJB
    private CourseDao courseDao;
    
    public Course addCourse(Course course){
        return courseDao.addCourse(course);
    }
    
    public List<Course> getAllCourses(){
        return courseDao.getAllCourses();
    }
    
    public void removeCourse(Course course){
        courseDao.removeCourse(course);
    }
    
    public Course findCourseById(Long courseId){
        return courseDao.findCourseById(courseId);
    }
    
    public Course updateCourse(Course course){
        return courseDao.updateCourse(course);
    }
    
}
