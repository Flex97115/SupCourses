/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.metamodel;

import com.supinfo.supcourses.entity.Course;
import com.supinfo.supcourses.entity.Quiz;
import com.supinfo.supcourses.entity.User;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author Gery
 */
@StaticMetamodel(Course.class)
public class Course_ {
    public static volatile SingularAttribute<Course,String> content;
    public static volatile SingularAttribute<Course,User> writer;
    public static volatile SingularAttribute<Course,Quiz> quiz;
}
