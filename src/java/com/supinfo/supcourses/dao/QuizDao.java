/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.dao;

import com.supinfo.supcourses.entity.Quiz;
import java.util.List;

/**
 *
 * @author Gery
 */
public interface QuizDao {

    Quiz addQuiz(Quiz quiz);
    
    List<Quiz> getAllQuiz();
    
    Quiz findQuizById(Long quizId);
    
    Quiz updateQuiz(Quiz quiz);
    
    void removeQuiz(Quiz quiz);
    
}
