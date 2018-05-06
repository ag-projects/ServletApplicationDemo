package com.agharibi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8081/ServletApplicationDemo/StatusDemo

@WebServlet("/StatusDemo")
public class StatusDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
       

    public StatusDemo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			String domainName = "https://app.pluralsight.com";
			
//			redirects a user to the different page -> pluralsight
//			response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
//			response.setHeader("Location", domainName);
			
			response.sendRedirect(domainName);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
