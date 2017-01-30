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
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "Course")
@SessionScoped
public class CourseController implements Serializable {
    
    private Course course;
    
    private String quizId;
    
    
    @EJB
    private CourseService courseService;
    
    
    public void loadData(String courseId){     
        Long id = Long.parseLong(courseId);
        this.course = courseService.findCourseById(id);
    }
    
    public String goToQuiz(){
        quizId = getCourse().getQuiz().getId().toString();
        return "quiz?faces-redirect=true&includeViewParams=true";
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @return the quizId
     */
    public String getQuizId() {
        return quizId;
    }

    /**
     * @param quizId the quizId to set
     */
    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }
        
}
