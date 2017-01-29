/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.managedbean;

import com.supinfo.supcourses.entity.Course;
import com.supinfo.supcourses.service.CourseService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "Course")
@RequestScoped
public class CourseController implements Serializable {
    
    private Course course;
    
    
    @EJB
    private CourseService courseService;
    
    
    public void loadData(String courseId){     
        Long id = Long.parseLong(courseId);
        course = courseService.findCourseById(id);
    }
    
    public void goToQuiz(){
        
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }
        
}
