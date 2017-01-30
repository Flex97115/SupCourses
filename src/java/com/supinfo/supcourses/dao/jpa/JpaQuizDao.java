/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao.jpa;

import com.supinfo.supcourses.dao.QuizDao;
import com.supinfo.supcourses.entity.Quiz;
import com.supinfo.supcourses.entity.User;
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
public class JpaQuizDao implements QuizDao{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        em.persist(quiz);
        return quiz;
    }

    @Override
    public List<Quiz> getAllQuiz() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Quiz> cq = cb.createQuery(Quiz.class);
        cq.from(Quiz.class);
        return em.createQuery(cq).getResultList();
    }

    @Override
    public Quiz findQuizById(Long quizId) {
        return em.find(Quiz.class, quizId);
    }

    @Override
    public void removeQuiz(Quiz quiz) {
        em.remove(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        em.merge(quiz);
        return quiz;
    }
    
    
}
