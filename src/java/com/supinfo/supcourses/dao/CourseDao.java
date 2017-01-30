/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao;

import com.supinfo.supcourses.entity.Course;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gery
 */
@Local
public interface CourseDao {
    
    Course addCourse(Course course);
    
    List<Course> getAllCourses();
    
    Course findCourseById(Long courseId);
    
    void removeCourse(Course course);
    
    Course updateCourse(Course course);
    
}
