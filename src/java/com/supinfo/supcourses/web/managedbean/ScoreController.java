/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.managedbean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "Score")
@RequestScoped
public class ScoreController implements Serializable {
    
    private int score;
    
    private int numQuestion;
    
    
    public void loadData(int score, int numQuestion){
        this.score = score;
        this.numQuestion = numQuestion;
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
