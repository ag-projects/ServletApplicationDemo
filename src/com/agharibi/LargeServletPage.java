package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8081/ServletApplicationDemo/LargeServletPage

@WebServlet("/LargeServletPage")
public class LargeServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String CONTENT_TYPE = "text/html";
    

    public LargeServletPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType(CONTENT_TYPE);
		
		PrintWriter out;
		if (GzipUitl.isGzipSupported(request) && !GzipUitl.isGzipDisabled(request)) {
			out = GzipUitl.getGzipWriter(response);
			response.setHeader("Content-Encoding", "gzip");
		} else {
			out = response.getWriter();	
		}
		
		String dummyLine = 		
				"The term Spring Core refers to the central "
				+ "part of the Spring Framework. The core is the cornerstone"
				+ " which everything else is built off of.This is a graphic"
				+ " published by Spring showing how Spring Core relates to"
				+ " other components in the Spring Framework.";
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Displaying request headers</title>");
		out.println("</head>");
		out.println("<body>");
		
		for(int i=0; i<1000; i++) {
			out.println(dummyLine + "</br>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
