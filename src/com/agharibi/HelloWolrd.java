package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

// http://localhost:8081/ServletApplicationDemo/HelloWolrd

@WebServlet("/HelloWolrd")
public class HelloWolrd extends GenericServlet {
	private static final long serialVersionUID = 1L;

    public HelloWolrd() {
        super();

    }

	public void service(ServletRequest request, 
			ServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Java EE: programming servlets");
	}

}
