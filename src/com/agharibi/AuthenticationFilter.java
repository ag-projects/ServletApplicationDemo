package com.agharibi;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import javafx.collections.ListChangeListener.Change;


@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {


    public AuthenticationFilter() {

    }

	public void destroy() {
		System.out.println("destroy method is called in " + this.getClass().getName());
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter method is called in " + this.getClass().getName());
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String ipAddress = request.getRemoteAddr();
		
		if(userName.equals("armen") && password.equals("pass")) {
			System.out.println("User logged in from  " + ipAddress + " @ " + LocalDateTime.now());
			chain.doFilter(request, response);
		} else {
			System.out.println("<h2>User is not authorized to access requested resources</h2>");
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init method is called in " + this.getClass().getName());
		
	}

}
