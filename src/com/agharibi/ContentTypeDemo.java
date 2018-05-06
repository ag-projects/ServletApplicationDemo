package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8081/ServletApplicationDemo/LargeServletPage/ContentTypeDemo
 
@WebServlet("/ContentTypeDemo")
public class ContentTypeDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String CONTENT_TYPE = "text/html";  
	private static final String CONTENT_TYPE = "application/vnd.ms-excel";  
       

    public ContentTypeDemo() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		
		PrintWriter out = response.getWriter();
		
		out.println("/news/science-environment");
		out.println("/capital/story/20180504-do-elon-musks-radical-work-ideas-add-up");
		out.println("capital/story/20180503-why-the-cost-of-equality-is-a-lot-lower-than-we-thought");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
