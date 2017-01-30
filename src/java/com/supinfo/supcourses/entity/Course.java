/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Gery
 */
@Entity
public class Course extends Timestampable  {
    
    
    private String title;
        
   
    @Column(length = 10000)
    private String content;
    
    @OneToOne
    private Quiz quiz;
    
    @ManyToOne
    private User writer;

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
     * @return the writer
     */
    public User getWriter() {
        return writer;
    }

    /**
     * @param writer the writer to set
     */
    public void setWriter(User writer) {
        this.writer = writer;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
    
}
