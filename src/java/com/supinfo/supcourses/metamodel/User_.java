/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.metamodel;

import com.supinfo.supcourses.entity.Role;
import com.supinfo.supcourses.entity.User;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author Gery
 */
@StaticMetamodel(User.class)
public class User_ {
    public static volatile SingularAttribute<User,String> email;
    public static volatile SingularAttribute<User,String> firstName;
    public static volatile SingularAttribute<User,String> lastName;
    public static volatile SingularAttribute<User,String> password;
    public static volatile SingularAttribute<User,Role> role;
    
}
