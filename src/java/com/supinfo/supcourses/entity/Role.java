/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Gery
 */
@Entity
public class Role extends Timestampable{
    private String readableName;
    private RoleEnum machineName;
    
    @OneToMany
    private List<User> users;

    /**
     * @return the readableName
     */
    public String getReadableName() {
        return readableName;
    }

    /**
     * @param readableName the readableName to set
     */
    public void setReadableName(String readableName) {
        this.readableName = readableName;
    }

    /**
     * @return the machineName
     */
    public RoleEnum getMachineName() {
        return machineName;
    }

    /**
     * @param machineName the machineName to set
     */
    public void setMachineName(RoleEnum machineName) {
        this.machineName = machineName;
    }

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    public enum RoleEnum {
        ADMIN("admin"),
        WRITER("writer"),
        STUDENT("student");
        
        private String name;
        
        RoleEnum(String name){
            this.name = name;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }
       
    }
    
    
    
}
