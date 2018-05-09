package com.agharibi;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/UploadServlet")
@MultipartConfig(
		fileSizeThreshold=1024*1024*2,
		maxFileSize=1024*1024*10,
		maxRequestSize=1024*1024*50
		)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html";
	private static final String SAVE_DIR = "UploadFiles";
	

    public UploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			String appPath = request.getServletContext().getRealPath("");
			String savePath = appPath + File.separator + SAVE_DIR;
			
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			
			for( Part part : request.getParts()) {
				String fileName = extractFileName(part);
				part.write(savePath + File.separator + fileName);
			}
			
			response.setContentType(CONTENT_TYPE);
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>File Upload Result</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("File uploaded successfully");
			
			out.println("</body>");
			out.println("</html>");
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		
		for (String item : items) {
			if(item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		return "";
	}

}
