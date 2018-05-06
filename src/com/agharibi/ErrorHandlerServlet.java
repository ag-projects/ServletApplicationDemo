package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// http://localhost:8081/ServletApplicationDemo/error.html
// http://localhost:8081/ServletApplicationDemo/ErrorHandlerServlet

@WebServlet("/ErrorHandlerServlet")
public class ErrorHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";

    public ErrorHandlerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
		String reqeustURI = (String) request.getAttribute("javax.servlet.error.request_uri");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Error Handling</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h3><font color=red>Error page: </font></h3>");
		out.println("<p>Status code: " + statusCode + "</p>");
		out.println("<p>Error message: " + errorMessage + "</p>");
		out.println("<p>Request_URI: " + reqeustURI + "</p>");
		out.println("<p>Servlet name: " + servletName + "</p>");
		
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
