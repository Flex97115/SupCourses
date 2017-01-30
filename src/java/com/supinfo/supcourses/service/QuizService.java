/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.service;

import com.supinfo.supcourses.dao.QuizDao;
import com.supinfo.supcourses.entity.Quiz;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Gery
 */
@Stateless
public class QuizService {
    
    @EJB
    private QuizDao quizDao;
    
    public Quiz addQuiz(Quiz quiz){
        return quizDao.addQuiz(quiz);
    }
    
    public List<Quiz> getAllQuiz(){
        return quizDao.getAllQuiz();
    }
    
    public Quiz findQuizById(Long quizId){
        return quizDao.findQuizById(quizId);
    }
    
    public void removeQuiz(Quiz quiz){
        quizDao.removeQuiz(quiz);
    }
    
    public Quiz updateQuiz(Quiz quiz){
        return quizDao.updateQuiz(quiz);
    }
    
}
