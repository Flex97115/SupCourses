/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.managedbean;

import com.supinfo.supcourses.entity.Course;
import com.supinfo.supcourses.service.CourseService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "Courses")
@ViewScoped
public class CoursesController implements Serializable {
    
    private List<Course> courses;
    
    private DataModel<Course> coursesModel;
    
    private Course course;
    
    private String courseId;
    

    @EJB
    private CourseService courseService;
    
    @PostConstruct
    public void init() {
        courses = courseService.getAllCourses();
        coursesModel = new ListDataModel<>(courses);
    }
   
    
    
    public String goToCourse(){        
        course = coursesModel.getRowData();
        setCourseId(course.getId().toString());
        return course != null ? "course?faces-redirect=true&includeViewParams=true" : "";
    }
    
    /**
     * @return the courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
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

    /**
     * @return the coursesModel
     */
    public DataModel<Course> getCoursesModel() {
        return coursesModel;
    }

    /**
     * @param coursesModel the coursesModel to set
     */
    public void setCoursesModel(DataModel<Course> coursesModel) {
        this.coursesModel = coursesModel;
    }

    /**
     * @return the courseId
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
}
