/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcourses.web.filter;

import com.sun.xml.ws.util.StringUtils;
import com.supinfo.supcourses.entity.User;
import com.supinfo.supcourses.service.UserService;
import java.io.IOException;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gery
 */
@WebFilter(urlPatterns = "/faces/private/*", filterName = "authentificationFilter")
public class AuthentificationFilter implements Filter {
    
    
    @EJB
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        User user = (User) httpRequest.getSession().getAttribute("user");
        String loginURL = httpRequest.getContextPath() + "/faces/public/login.xhtml"; 

        if(user == null){
            String contextPath = httpRequest.getContextPath();
            httpResponse.sendRedirect(loginURL);
        }
        chain.doFilter(request, response);
        
    }

    @Override
    public void destroy() {
    }
    
}
