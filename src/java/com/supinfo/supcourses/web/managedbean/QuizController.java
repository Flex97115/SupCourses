/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.managedbean;

import com.supinfo.supcourses.entity.Question;
import com.supinfo.supcourses.entity.Quiz;
import com.supinfo.supcourses.service.QuizService;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "Quiz")
@SessionScoped
public class QuizController implements Serializable {
    
    private Quiz quiz;
    
    private List<Question> questions;
    
    private int score;
    
    private int numQuestion;
    
    @EJB
    private QuizService quizService;
    
    public void loadData(String quizId){
        Long id = Long.parseLong(quizId);
        setQuiz(quizService.findQuizById(id));
        questions = quiz.getQuestions();
        setNumQuestion(questions.size());
        setScore(0);
        
    }
    
    public String goToCourses(){
        return "index?faces-redirect=true";
    }
    
    public String submit(){     
        //Calcule score comparing user response to real response
        setScore(questions.stream()
                .mapToInt(q1 -> {
                    return q1.isResponse() == q1.isUserResponse()? 1 : 0;
                }).sum());
        
        return "score?faces-redirect=true&includeViewParams=true";
    }

    /**
     * @return the quiz
     */
    public Quiz getQuiz() {
        return quiz;
    }

    /**
     * @param quiz the quiz to set
     */
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }    

    /**
     * @return the questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the numQuestion
     */
    public int getNumQuestion() {
        return numQuestion;
    }

    /**
     * @param numQuestion the numQuestion to set
     */
    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }
    
    
    
    
}
