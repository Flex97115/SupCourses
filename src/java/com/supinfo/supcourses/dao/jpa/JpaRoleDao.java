/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao.jpa;

import com.supinfo.supcourses.dao.RoleDao;
import com.supinfo.supcourses.entity.Role;
import com.supinfo.supcourses.entity.Role.RoleEnum;
import com.supinfo.supcourses.entity.Role_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Gery
 */
@Stateless
public class JpaRoleDao implements RoleDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Role addRole(Role role) {
        em.persist(role);
        return role;
    }

    @Override
    public List<Role> getAllRoles() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        cq.from(Role.class);
        return em.createQuery(cq).getResultList();
    }

    @Override
    public Role getAdminRole() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> role = cq.from(Role.class);
        cq.where(cb.equal(role.get(Role_.readableName), RoleEnum.ADMIN.getName()));
        return em.createQuery(cq).getSingleResult();
    }

    @Override
    public Role getStudentRole() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> role = cq.from(Role.class);
        cq.where(cb.equal(role.get(Role_.readableName), RoleEnum.STUDENT.getName()));
        return em.createQuery(cq).getSingleResult();
    }

    @Override
    public Role getWriterRole() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Role> cq = cb.createQuery(Role.class);
        Root<Role> role = cq.from(Role.class);
        cq.where(cb.equal(role.get(Role_.readableName), RoleEnum.WRITER.getName()));
        return em.createQuery(cq).getSingleResult();
    }
    
}
