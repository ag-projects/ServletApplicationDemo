package com.agharibi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final String TEXT_HTML = "text/html";
	private static final long serialVersionUID = 1L;

    public UserInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType(TEXT_HTML);
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		out.println("<h3>Reading query string data via getParameter</h3>");
		out.println("<div>");
		out.println("<p>First name -> "+ firstName +"</p>");
		out.println("<p>Last name -> "+ lastName +"</p>");
		out.println("</div>");	
		
		
		out.println("<h3>Reading query string data via getParameterNames</h3>");
		out.println("<div>");
		
		Enumeration<String> params = request.getParameterNames();
		while(params.hasMoreElements()) {
			String param = params.nextElement();
			String value = request.getParameter(param);
			out.println("<p>" + param + " => " + value + "</p>");
		}
		out.println("<div>");
		
		
		out.println("<h3>Reading query string data via getParameterMap</h3>");
		out.println("<div>");
		
		Map<String, String[]> map = request.getParameterMap();
		Set<String> keys = map.keySet();
		for(String key : keys) {
			String[] values = map.get(key);
			out.println("<p>" + key);
			
			for(int i=0; i< values.length; i++) {
				out.print(values[i]);
			}
			out.println("</p>");
		}
		out.println("<div>");
	}


	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
