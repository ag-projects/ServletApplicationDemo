package com.aghairbi.UrlRewritingDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeUrl")
public class WelcomeUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";

    public WelcomeUrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		
		String guestName = request.getParameter("guestName");
		String email = request.getParameter("email");
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Welcome page</title>");
		out.println("</head>");
		out.println("<body>");
		
		String query = "guestName=" + guestName + "&email=" + email;
		out.println("<a href='PreviewUrl?" + query + "'>Preveiw Data</a> &nbsp;" 
				  + "<a href='SaveData?'" +  query + "'>Save Date</a>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
