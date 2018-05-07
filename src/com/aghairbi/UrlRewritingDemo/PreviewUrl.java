package com.aghairbi.UrlRewritingDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PreviewUrl")
public class PreviewUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";

    public PreviewUrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		out.println("<p>Guest name: " + guestName +"</p>");
		out.println("<p>Email address: " + email + " </p>");
		
		String query = "guestName=" + guestName + "&email=" + email;
		out.println("<a href='SaveData?'"+ query +"'>Save Data</a>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
