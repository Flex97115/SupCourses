/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao.jpa;

import com.supinfo.supcourses.dao.QuestionDao;
import com.supinfo.supcourses.entity.Question;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gery
 */
@Stateless
public class JpaQuestionDao implements QuestionDao {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Question addQuestion(Question question) {
        em.persist(question);
        return question;
    }

    @Override
    public Question findQuestionById(Long questionId) {
        return em.find(Question.class, questionId);
    }

    @Override
    public void removeQuestion(Question question) {
        em.remove(question);
    }
}
