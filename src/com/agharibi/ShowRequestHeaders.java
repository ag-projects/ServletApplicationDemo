package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

  // http://localhost:8081/ServletApplicationDemo/ShowRequestHeaders

@WebServlet("/ShowRequestHeaders")
public class ShowRequestHeaders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";

    public ShowRequestHeaders() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Displaying request headers</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>All request headers:</h1>");
		
		// headers
		out.println("<p><b>Request Method: </b>" + request.getMethod() + "</p>");
		out.println("<p><b>Request URI: </b>" + request.getRequestURI() + "</p>");
		out.println("<p><b>Request Protocol: </b>" + request.getProtocol() + "</p>");
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			out.println("<p><b>" + headerName + ":</b>" + request.getHeader(headerName) + "</p>");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
