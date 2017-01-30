/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao;

import com.supinfo.supcourses.entity.Question;
import javax.ejb.Local;

/**
 *
 * @author Gery
 */
@Local
public interface QuestionDao {
    
    Question addQuestion(Question question);
    
    Question findQuestionById(Long questionId);
    
    Question updateQuestion(Question question);
    
    void removeQuestion(Question question);
    
}
