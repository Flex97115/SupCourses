/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao.jpa;

import com.supinfo.supcourses.dao.CourseDao;
import com.supinfo.supcourses.entity.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Gery
 */
@Stateless
public class JpaCourseDao implements CourseDao {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Course addCourse(Course course) {
        em.persist(course);
        return course;
    }

    @Override
    public List<Course> getAllCourses() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        cq.from(Course.class);
        return em.createQuery(cq).getResultList();
    }

    @Override
    public Course findCourseById(Long courseId) {
        return em.find(Course.class, courseId);
    }

    @Override
    public void removeCourse(Course course) {
        em.remove(course);
    }
    
}
