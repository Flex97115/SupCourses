/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao.jpa;

import com.supinfo.supcourses.dao.UserDao;
import com.supinfo.supcourses.entity.User;
import com.supinfo.supcourses.entity.User_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 *
 * @author Gery
 */
@Stateless
public class JpaUserDao implements UserDao {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public User addUser(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        cq.from(User.class);
        return em.createQuery(cq).getResultList();
        
    }

    @Override
    public User findUserById(Long userId) {
        return em.find(User.class, userId);
    }

    @Override
    public void removeUser(User user) {
        em.remove(this);
    }

    @Override
    public User findUserByMail(String mail) {
        try {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        cq.where(cb.equal(user.get(User_.email), mail.toLowerCase()));
        return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e){
            return null;
        }
        
    }

    @Override
    public User authentify(String mail, String password) {
        try {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        
        cq.where(cb.and(cb.equal(user.get(User_.email), mail.toLowerCase()),cb.equal(user.get(User_.password), password)));
        return em.createQuery(cq).getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public User updateUser(User user) {
        em.merge(user);
        return user;
    }
    
}
