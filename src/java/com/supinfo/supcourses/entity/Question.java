/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.entity;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gery
 */
@Entity
public class Question extends Timestampable {
    
    private String content;
    
    private boolean response;
    
    private boolean userResponse = true;
    
    @ManyToOne
    private Quiz quiz;
    
    public Question(){
        
    }
    
    public Question(String content, boolean response ){
        this.content = content;
        this.response = response;
    }
    
    
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the response
     */
    public boolean isResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(boolean response) {
        this.response = response;
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
     * @return the userResponse
     */
    public boolean isUserResponse() {
        return userResponse;
    }

    /**
     * @param userResponse the userResponse to set
     */
    public void setUserResponse(boolean userResponse) {
        this.userResponse = userResponse;
    }
    
    
    
}
