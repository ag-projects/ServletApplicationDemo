package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";

    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        String[] hobbies = request.getParameterValues("hobbies");
        String country = request.getParameter("country");
        String[] languages = request.getParameterValues("languages");

        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        out.println("<div>");
        out.println("<p>User name => " + userName + "</p>");
        out.println("<p>Password => " + password + "</p>");
        out.println("<p>Gender => " + gender + "</p>");

        out.println("<p>Hobbies => </p>");
            for (int i=0; i< hobbies.length; i++) {
                out.println(hobbies[i] + "<br/>");
            }

        out.println("<p>Country => " + country + "</p>");
        out.println("<p>Languages => </p>");
        for (int i=0; i<languages.length; i++) {
            out.println(languages[i] + "</br>");
        }


        out.println("</div>");
	}


	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Posting data from doPost method..");
		doGet(request, response);
	}

}
