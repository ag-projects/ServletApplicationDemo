package com.agharibi.hiddenfields;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Preview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview page</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h3>Please confirm your information:</h3>");
		out.println("<p>Guest name:" + guestName + "</p>");
		out.println("<p>Email address:" + email + "</p>");
		
		out.println("<form name='frm' action='SaveData' method='post'>");
		out.println("<input type='hidden' name='guestName' value='"+ guestName + "'/>");
		out.println("<input type='hidden' name='email' value='"+ email + "'/>");
		out.println("<p><input type='submit' value='Save' name='btnSave' /></p>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
