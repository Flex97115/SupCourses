/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.servlet.listener;

import com.sun.faces.facelets.util.Path;
import com.supinfo.supcourses.entity.Course;
import com.supinfo.supcourses.entity.Question;
import com.supinfo.supcourses.entity.Quiz;
import com.supinfo.supcourses.entity.Role;
import com.supinfo.supcourses.entity.User;
import com.supinfo.supcourses.service.CourseService;
import com.supinfo.supcourses.service.QuestionService;
import com.supinfo.supcourses.service.QuizService;
import com.supinfo.supcourses.service.RoleService;
import com.supinfo.supcourses.service.UserService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;
import java.util.stream.Stream;
import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Gery
 */
public class SupCoursesServletContextListener implements ServletContextListener {

    @EJB
    private UserService userService;
    
    @EJB
    private RoleService roleService;
    
    @EJB
    private CourseService courseService;
    
    @EJB
    private QuizService quizService;
    
    @EJB
    private QuestionService questionService;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if(roleService.getAllRoles().isEmpty()){
            Role adminRole = new Role();
            adminRole.setMachineName(Role.RoleEnum.ADMIN);
            adminRole.setReadableName(Role.RoleEnum.ADMIN.getName());
            roleService.addRole(adminRole);
            
            Role writerRole = new Role();
            writerRole.setMachineName(Role.RoleEnum.WRITER);
            writerRole.setReadableName(Role.RoleEnum.WRITER.getName());
            roleService.addRole(writerRole);
            
            Role studentRole = new Role();
            studentRole.setMachineName(Role.RoleEnum.STUDENT);
            studentRole.setReadableName(Role.RoleEnum.STUDENT.getName());
            roleService.addRole(studentRole);
            
        }
        if(userService.getAllUsers().isEmpty()){
            User admin = new User();
            admin.setEmail("admin@supinfo.com");
            admin.setFirstName("admin");
            admin.setLastName("admin");
            admin.setPassword("admin");
            admin.setRole(roleService.getAdminRole());
            userService.addUser(admin);
            
            User student = new User();
            student.setEmail("student@supinfo.com");
            student.setFirstName("student");
            student.setLastName("student");
            student.setPassword("student");
            student.setRole(roleService.getStudentRole());
            userService.addUser(student);
            
            User writer = new User();
            writer.setEmail("writer@supinfo.com");
            writer.setFirstName("writer");
            writer.setLastName("writer");
            writer.setPassword("writer");
            writer.setRole(roleService.getWriterRole());
            userService.addUser(writer);
        }
        if(courseService.getAllCourses().isEmpty()){
            String relativeWebPath = "/resources/txt/1.txt";
            String absoluteDiskPath = sce.getServletContext().getRealPath(relativeWebPath);
            java.nio.file.Path path = Paths.get(absoluteDiskPath);
            try {
                String content = Files.lines(path, StandardCharsets.UTF_8).collect(joining(" "));
                Course course = new Course();
                course.setTitle("Comment extraire des données d’un fichier audio ?");
                course.setContent(content);
                courseService.addCourse(course);
                Quiz quiz = new Quiz();
                quiz.setCourse(course);
                List<Question> questions = new ArrayList<>();
                Question q1 = new Question("Essentia est-il essentiel pour l'extraction des données ?", true);
                q1 = questionService.addQuestion(q1);
                questions.add(q1);
                Question q2 = new Question("Le langage utilisé dans ce tutoriel est le java ?", false);
                q2 = questionService.addQuestion(q2);
                questions.add(q2);
                Question q3 = new Question("Essentia est compatible avec la version 3 de python ?", false);
                q3 = questionService.addQuestion(q3);
                questions.add(q3);
                Question q4 = new Question("Nous pouvons extraire les battements par minute d'une musique ?", true);
                q4 = questionService.addQuestion(q4);
                questions.add(q4);
                Question q5 = new Question("Les données extraites sont stocké dans un fichier json ?", true);
                q5 = questionService.addQuestion(q5);
                questions.add(q5);
                quiz.setQuestions(questions);
                course.setQuiz(quizService.addQuiz(quiz));
                courseService.updateCourse(course);
                

            } catch (IOException ex) {
                Logger.getLogger(SupCoursesServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            relativeWebPath = "/resources/txt/2.txt";
            absoluteDiskPath = sce.getServletContext().getRealPath(relativeWebPath);
            path = Paths.get(absoluteDiskPath);
            try {
                String content = Files.lines(path, StandardCharsets.UTF_8).collect(joining(" "));
                Course course = new Course();
                course.setTitle("Installer python sous mac");
                course.setContent(content);
                courseService.addCourse(course);
                Quiz quiz = new Quiz();
                quiz.setCourse(course);
                List<Question> questions = new ArrayList<>();
                Question q1 = new Question("Il y a une seul manière d'installer python ?", false);
                q1 = questionService.addQuestion(q1);
                questions.add(q1);
                Question q2 = new Question("On peut installer qu'une version de python ?", false);
                q2 = questionService.addQuestion(q2);
                questions.add(q2);
                Question q3 = new Question("Homebrew nous permet d'installer python en ligne de commande ?", true);
                q3 = questionService.addQuestion(q3);
                questions.add(q3);
                Question q4 = new Question("La commande 'brew' permet d'appeler Homebrew  ?", true);
                q4 = questionService.addQuestion(q4);
                questions.add(q4);
                Question q5 = new Question("Il est préférable d'utiliser Homebrew pour l'installation de python ?", true);
                q5 = questionService.addQuestion(q5);
                questions.add(q5);
                quiz.setQuestions(questions);
                course.setQuiz(quizService.addQuiz(quiz));
                courseService.updateCourse(course);
                
            } catch (IOException ex) {
                Logger.getLogger(SupCoursesServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            relativeWebPath = "/resources/txt/3.txt";
            absoluteDiskPath = sce.getServletContext().getRealPath(relativeWebPath);
            path = Paths.get(absoluteDiskPath);
            try {
                String content = Files.lines(path, StandardCharsets.UTF_8).collect(joining(" "));
                Course course = new Course();
                course.setTitle("Installer SQLite sous mac");
                course.setContent(content);
                courseService.addCourse(course);
                Quiz quiz = new Quiz();
                quiz.setCourse(course);
                List<Question> questions = new ArrayList<>();
                Question q1 = new Question("SQLite est moteur de base de donnée relationelle léger ?", true);
                q1 = questionService.addQuestion(q1);
                questions.add(q1);
                Question q2 = new Question("On peut manipuler une base de donnée SQLite avec le langage SQL ?", true);
                q2 = questionService.addQuestion(q2);
                questions.add(q2);
                Question q3 = new Question("Homebrew nous permet d'installer SQLite en ligne de commande ?", true);
                q3 = questionService.addQuestion(q3);
                questions.add(q3);
                Question q4 = new Question("La commande 'brew' permet d'appeler Homebrew  ?", true);
                q4 = questionService.addQuestion(q4);
                questions.add(q4);
                Question q5 = new Question("SQLite est beaucoup utilisé sur les applications mobiles ?", true);
                q5 = questionService.addQuestion(q5);
                questions.add(q5);
                quiz.setQuestions(questions);
                course.setQuiz(quizService.addQuiz(quiz));
                courseService.updateCourse(course);
                
            } catch (IOException ex) {
                Logger.getLogger(SupCoursesServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
