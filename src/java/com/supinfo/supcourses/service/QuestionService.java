/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.service;

import com.supinfo.supcourses.dao.QuestionDao;
import com.supinfo.supcourses.entity.Question;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Gery
 */
@Stateless
public class QuestionService {
    @EJB
    private QuestionDao questionDao;
    
    public Question addQuestion(Question question){
        return questionDao.addQuestion(question);
    }
    
    public void removeQuestion(Question question){
        questionDao.removeQuestion(question);
    }
    
    public Question findQuestionById(Long questionId){
        return questionDao.findQuestionById(questionId);
    }
    
    public Question updateQuestion(Question question){
        return questionDao.updateQuestion(question);
    }
}
